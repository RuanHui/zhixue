package cn.arunner.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.arunner.zhixue.utils.BaseServlet;


public class IndexAction extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String index(HttpServletRequest request,HttpServletResponse response) {
		return "/jsp/index.jsp";
	}
}
