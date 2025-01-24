package com.sofi.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	
	
	public static Connection getDbConn() throws ClassNotFoundException, SQLException {
		
		//1. Register the Vendor Driver
		Class.forName(DbUtilHelperConstant.DRIVER_CLASS);
		
		//2. Establish communication with the database
		Connection con = null ;
		try {
			con = DriverManager.getConnection(DbUtilHelperConstant.DB_URL,DbUtilHelperConstant.USERNAME ,DbUtilHelperConstant.PASSWORD);
		}catch(Exception e) {
			System.out.println("SQL ERROR: " + e.getMessage());
			throw e;
		}
		
		return con; 
	}
	
}
