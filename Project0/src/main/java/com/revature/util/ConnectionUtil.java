package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.mariadb.jdbc.Driver;


public class ConnectionUtil {
	
	private ConnectionUtil() {		
	}
	
	public static Connection getCon() throws SQLException {
		
		DriverManager.registerDriver(new Driver());
		
		String url = System.getenv("db_url");
		String username = System.getenv("db_username");
		String password = System.getenv("db_password");
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		return con;
		
	}

}
