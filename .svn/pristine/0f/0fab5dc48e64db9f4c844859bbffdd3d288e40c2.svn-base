package cn.arunner.web.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.arunner.zhixue.utils.BaseServlet;
import cn.arunner.zhixue.utils.Wisdom;

public class WisdomAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String windoms = Wisdom.getWisdom();
		String[] values = windoms.split("#");
		String name = values[0];
		String wisdom = values[1];
		request.setAttribute("name", name);
		request.setAttribute("wisdom", wisdom);
		System.out.println(name + "============" + wisdom);
		return "loginJSP";
	}
}
