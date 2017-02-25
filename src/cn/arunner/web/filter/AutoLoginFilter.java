package cn.arunner.web.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import cn.arunner.zhixue.domain.User;
import cn.arunner.zhixue.service.UserService;
import cn.arunner.zhixue.service.impl.UserServiceImpl;
import cn.arunner.zhixue.utils.CookieUtils;

public class AutoLoginFilter implements Filter{

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		/**
		 * 判断session中是否有用户的信息:
		 * * session中如果有:放行.
		 * * session中没有:
		 *    * 从Cookie中获取:
		 *        * Cookie中没有:放行.
		 *        * Cookie中有:
		 *            * 获取Cookie中存的用户名和密码到数据库查询.
		 *                * 没有查询到:放行.
		 *                * 查询到:将用户信息存入到session . 放行.
		 */
		
		HttpServletRequest req = (HttpServletRequest) request;
		User existUser = (User) req.getSession().getAttribute("existUser");
		
		if (existUser != null) {
			chain.doFilter(req, response);
		} else {
			Cookie[] cookies = req.getCookies();
			Cookie cookie = CookieUtils.findCookie(cookies, "autoLogin");
			if (cookie == null) {
				chain.doFilter(req, response);
			} else {
				System.out.println("自动登录啦+++++++++++++++++++++++=");
				String value = cookie.getValue();
				String username = value.split("#")[0];
				String password = value.split("#")[1];
				UserService userService = new UserServiceImpl();
				try {
					existUser = userService.login(username, password);
					System.out.println("====================");
					if (existUser == null) {
						chain.doFilter(req, response);
					} else {
						req.getSession().setAttribute("existUser", existUser);
						chain.doFilter(req, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}