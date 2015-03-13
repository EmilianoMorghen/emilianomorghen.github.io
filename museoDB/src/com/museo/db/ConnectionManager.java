package com.museo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String HOSTNAME = "127.0.0.1";
	private static final String PORT = "3306";
	private static final String DBNAME = "museo";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	
	public static void main(String args[]){
		try {
			getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName(JDBC_DRIVER);
		Connection conn = null;
		
		conn = DriverManager.getConnection("jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DBNAME,USERNAME, PASSWORD);
		return conn;
	}
	
}
