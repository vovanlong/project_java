package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class DBConnectionUtil {
	private static String url;
	private static String user;
	private static String password;
	private static Connection conn = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ResourceBundle rd = ResourceBundle.getBundle("/config/database");
			url = rd.getString("url"); 
			user = rd.getString("username");
			password = rd.getString("password");

			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Không thể nạp driver");
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		System.out.println(DBConnectionUtil.getConnection());
	}
}
