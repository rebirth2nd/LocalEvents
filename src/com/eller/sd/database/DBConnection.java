package com.eller.sd.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {
	
	private static DBConnection singleton = new DBConnection();//Singleton class
	Connection conn;//Eager initialization
	
	private String username;
	private String password;
	private String url;
	private String driver;
	private String DBname;
	
/*	static
	{
		new DBConnection();
		createConnection();
		
	}*/
	private DBConnection()
	{
		username="root";
		password="3081938";
		DBname="happening_modified";
		url="jdbc:mysql://localhost/";
		driver = "com.mysql.jdbc.Driver";
		createConnection();
	}
	
	public static DBConnection getDBConnection()
	{
		return singleton;
	}
	
	public Connection getConn() {
		return conn;
	}

	public void createConnection()
	{
		String DBDriverPath = url+DBname+"?user="+username+"&password="+password;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DBDriverPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
