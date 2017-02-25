package cn.arunner.zhixue.service.impl;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import cn.arunner.zhixue.dao.UserDao;
import cn.arunner.zhixue.dao.impl.UserDaoImpl;
import cn.arunner.zhixue.domain.User;
import cn.arunner.zhixue.service.UserService;

@Transactional
public class UserServiceImpl implements UserService{
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	//登录
	@Override
	@Test
	public User login(String username, String password) throws SQLException {
		//FIXME 自动登录时userdao为空(不能注入)
		return userDao.login(username,password);
	}

	//注册
	@Override
	public void register(User user) throws SQLException {
		//MailUtils.sendMail(user.getEmail(), user.getUid());
		userDao.register(user);
	}
	
}
