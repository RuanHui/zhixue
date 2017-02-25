package cn.arunner.zhixue.dao;

import java.sql.SQLException;

import cn.arunner.zhixue.domain.User;

public interface UserDao {

	User login(String username, String password) throws SQLException;

	void register(User user) throws SQLException;

}
