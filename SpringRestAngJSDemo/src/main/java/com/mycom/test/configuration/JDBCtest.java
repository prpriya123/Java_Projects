package com.mycom.test.configuration;

import java.sql.*;

public class JDBCtest {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";//com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);//"com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			String sql = "INSERT INTO test_user " + "VALUES (100, 'Zara', 'hyd', 'test@test.com')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO test_user " + "VALUES (101, 'Mahnaz', 'mom', 'test1@test.com')";
			stmt.executeUpdate(sql);
			sql = "INSERT INTO test_user " + "VALUES (102, 'Zaid', 'hyd', 'test3@test.com')";
			stmt.executeUpdate(sql); 
			sql = "INSERT INTO test_user " + "VALUES(103, 'Sumit', 'chennai', '2test@test.com')";
			stmt.executeUpdate(sql);
			System.out.println("Inserted records into the table...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try 
		} // end try
		System.out.println("Goodbye!");
	}// end main
}
