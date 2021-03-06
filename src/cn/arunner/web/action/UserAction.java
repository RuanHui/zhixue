package cn.arunner.web.action;


import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.arunner.zhixue.domain.User;
import cn.arunner.zhixue.service.UserService;
import cn.arunner.zhixue.utils.CookieUtils;
import cn.arunner.zhixue.utils.MD5Utils;
import cn.arunner.zhixue.utils.UUIDUtils;

/**
 * 用户的servlet
 */
public class UserAction extends ActionSupport {
	private User user ;
	public void setUser(User user) {
		this.user = user;
	}

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * 用户登录的方法
	 * @param request
	 * @param response
	 * @return
	 */
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			password = MD5Utils.MD5(password);
			User user = userService.login(username,password);
			
			if(user != null) {
				//自动登录
				String autoLogin = request.getParameter("autoLogin");
				if ("true".equals(autoLogin)) {
					Cookie cookie = new Cookie("autoLogin", user.getUsername() + "#" + user.getPassword());
					cookie.setMaxAge(60 * 60 * 24 * 7);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				//记住用户名
				String remember = request.getParameter("remember");
				if ("true".equals(remember)) {
					Cookie cookie = new Cookie("username", user.getUsername());
					cookie.setMaxAge(60 * 60 * 24 * 7);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
				request.getSession().setAttribute("existUser", user);
//				response.sendRedirect( request.getContextPath()+ "/jsp/index.jsp");
				return "login";
			}else {
				request.setAttribute("msg", "登录失败");
				return "wisdom";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 用户注册的方法
	 * @param request
	 * @param response
	 * @return
	 */
	public String register() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
//			User user = (User) BeanFactory.getBean("User");
			Map<String, String[]> map = request.getParameterMap();
			user.setUid(UUIDUtils.getUUID());
			BeanUtils.populate(user, map);
			String psw = request.getParameter("password");
			//存入经过MD5加密后的密码
			user.setPassword(MD5Utils.MD5(psw));
			user.setState(0);
//			UserService userService = (UserService) BeanFactory.getBean("UserService");
			userService.register(user);
			request.setAttribute("msg", "注册成功");
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}
	
	/**
	 * 用户退出的方法
	 */
	public String logout() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.getSession().removeAttribute("existUser");
		Cookie[] cookies = request.getCookies();
		Cookie cookie = CookieUtils.findCookie(cookies, "autoLogin");
		if (cookie != null) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
		return "logout";
	}

	
}
