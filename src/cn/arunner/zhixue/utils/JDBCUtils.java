package cn.arunner.zhixue.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();
	public static Connection getConnection() throws SQLException {
		return DATA_SOURCE.getConnection();
	}
	public static DataSource getDataSource() {
		return DATA_SOURCE;
	}
}
