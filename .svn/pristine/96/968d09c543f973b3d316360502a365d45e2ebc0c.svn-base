package cn.arunner.zhixue.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.arunner.zhixue.dao.UserDao;
import cn.arunner.zhixue.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	//登录
	@SuppressWarnings("unchecked")
	@Override
	public User login(String username, String password) throws SQLException {
		//使用HQL查询数据库
		String hql = "FROM User WHERE username = ? AND password = ?";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql,username,password);
		if (list != null && list.size() != 0) {
			return list.get(0);
		}
		return null;
	}

	//注册
	@Override
	public void register(User user) throws SQLException {
		this.getHibernateTemplate().save(user);
	}
	
}
