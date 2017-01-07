/*
 * A class to manage database connection
 */

package com.example;

import java.sql.*;

public class DbCon {
			
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://144.217.93.255/db_ifa";
	
	static Connection conn = null;
	Statement stmt = null;
	
	/*
	 * constructor, just to open connection to MySQL server. Do not close connection
	 */
	public DbCon(){
		
		// Register JDBC driver
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	      
	    openCon();
	}	
		
	/*
	 * Method to open MySQL connection
	 */
	public void openCon(){
		// Open a connection if it's not already opened
		if (conn != null){
		    try {
		    	conn = DriverManager.getConnection(DB_URL,"db","Enter_123");
		    } catch (SQLException e) {
		    
		    }
		}
	}
	
	/*
	 * Method to close MySQL connection
	 */
	public void closeCon(){
		// close only if conn is opened
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/*
	 * Method to get connection
	 */
	public Connection getCon(){
		// if there is no already existing connection, create one and return it
		if (conn == null){
			openCon();
			return conn;
		} else {
			// else, just return the existing one
			return conn;
		}
	}
	
}

