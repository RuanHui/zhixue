package cn.arunner.zhixue.utils;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * 发送邮件的工具类
 * @author aRunner
 *
 */
public class MailUtils {
	public static void sendMail(String to,String code) {
		try {
			//获得连接
			Properties props = new Properties();
			Session session = Session.getInstance(props, new Authenticator() {
	
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					//修改邮箱地址============================
					return new PasswordAuthentication("service@store.com", "111");
				}
			});
			//构建邮件
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("service@store.com"));
			//设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			//主题
			message.setSubject("欢迎注册致学");
			//正文
			message.setContent("<h1>这是一封来自致学的激活邮件:请点击下面链接激活!</h1><h3><a href='http://localhost:8080/ZhiXue/UserServlet?method=active&code="+code+"'>http://localhost:8080/ZhiXue/UserServlet?method=active&code="+code+"</a></h3>", "text/html;charset=utf-8");
			//发送邮件
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
