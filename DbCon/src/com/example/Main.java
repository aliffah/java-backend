/*
 * Driver class example to use DbCon class (database connection manager)
 */

package com.example;

import java.sql.*;
import com.example.DbCon;

import com.example.User;

public class Main {
	
	static Statement stmt = null;
	Connection con = null;
	DbCon dbCon = null; // declare a variable for DbCon object
	
	
	public static void main(String[] args) {
		
			// instantiate DbCon object
			//dbCon = new DbCon();
			
			// use the connection to do some query
			//testquery();
			
			// how to use object User
			User ifaUser = new User();
			ifaUser.setId(11);
			
			System.out.println("ID : " + ifaUser.getId());
	}
	
	/*
	 * Method to test DbCon class
	 */
	public void testquery(){
		
		try {
			// get connection using DbCon
			con = dbCon.getCon();
			
			stmt = con.createStatement();  
		    String query="select * from User;";
		    ResultSet rs = stmt.executeQuery(query);

		    // Extract data from result set
		    while(rs.next()){
		    	
		    	//Retrieve by column name
		        int id  = rs.getInt("id");
		        String username = rs.getString("username");
		        String password = rs.getString("PASSWORD");
		        String date = rs.getString("reg_date");

		        //Display values
		        System.out.print("ID : " + id);
		        System.out.print(", Username : " + username);
		        System.out.print(", Password : " + password);
		        System.out.print(", Reg. Date : " + date);
		        
		        System.out.print("\n");
		        
		    } 
		} catch (SQLException e){ 	  
		};
		
	}

}