package cn.arunner.zhixue.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String MD5(String psw) {
		try {
			/*//拿到一个MD5转换器
			MessageDigest md = MessageDigest.getInstance("MD5");
			//将传进来的密码转成字节数组
			byte[] bytes = psw.getBytes();
			md.update(bytes);
			//转换并返回结果,也是字节数组,包含16个元素
			byte[] digest = md.digest();*/
			/*
			 * 在每个密码之后都加上字符串"aRunner",随后生成md5加密的密码
			 */
			String str = psw + "aRunner";
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
}
