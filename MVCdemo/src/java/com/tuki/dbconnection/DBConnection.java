package com.tuki.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private Connection conn;
	public static DBConnection db;

	private DBConnection() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "qlvt5";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "1234";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
		}catch(ClassNotFoundException e) {
			System.out.println("Load driver ko thanh cong");
			
		}
		catch (Exception sqle) {
			System.out.println("Loi:"+sqle.getMessage());
		}
	}


	public static synchronized DBConnection getDbCon() {
		if (db == null) {
			db = new DBConnection();
		}
		return db;

	}

	public Connection getConn() {
		return conn;
	}
}
