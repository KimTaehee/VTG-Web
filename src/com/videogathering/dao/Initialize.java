package com.videogathering.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Initialize {
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtg", "root", "xjvmrjf1");
			System.out.println("Success!");
		} catch (SQLException ex) {
			System.out.println("SQLException:" + ex);
		} catch (Exception e) {
			System.out.println("Exception:" + e);
		}
		return conn;
	}
}
