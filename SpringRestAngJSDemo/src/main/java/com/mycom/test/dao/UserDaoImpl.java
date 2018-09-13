package com.mycom.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mycom.test.entity.UserEntity;


@Repository
public class UserDaoImpl implements UserDao {
	
	@Override
	public void submitUsers(UserEntity user) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");//"com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "password");
			conn.setAutoCommit(false);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();

			String sql = "INSERT INTO test_user(username, address,email)  VALUES ( '"+user.getUsername()+"', '"+user.getAddress()+"', '"+user.getEmail()+"')";
			stmt.executeUpdate(sql);
			conn.commit();
			System.out.println("Inserted records into the table...");

		} catch  (Exception e) {
			// Handle errors for Class.forName
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Error in while saving user infor for user:"+user.getUsername());
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


	}

	@Override
	public void submitUsersErr(final List<UserEntity> users) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");//"com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "password");
			conn.setAutoCommit(false);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			for (UserEntity user : users) {
				String sql = "INSERT INTO test_user(username, address,email)  VALUES ( '"+user.getUsername()+"', '"+user.getAddress()+"', '"+user.getEmail()+"')";
				stmt.executeUpdate(sql);
			}
			conn.commit();
			System.out.println("Inserted records into the table...");

		} catch  (Exception e) {
			// Handle errors for Class.forName
			conn.rollback();
			e.printStackTrace();
			throw new Exception("Error in while saving user info"+e.getMessage());
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
		}
		
	}

	/*@Autowired
	   private SessionFactory sessionFactory;

	@Override
	public void submitUsers(UserEntity user) throws Exception {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void submitUsersErr(List<UserEntity> users) throws Exception {
		for (UserEntity user : users) {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
		}
	}*/

}
