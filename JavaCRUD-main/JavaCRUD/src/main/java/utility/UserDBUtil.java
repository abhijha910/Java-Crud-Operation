package utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.User;

public class UserDBUtil {

	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

	// Method to add a new user
	public static boolean addUser(String fname, String lname, String phone, String email, String address, String uname, String passwd) {
		boolean success = false;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			// Insert into database with phone and address fields
			String sql = "INSERT INTO user VALUES(0, '" + fname + "', '" + lname + "', '" + phone + "', '" + email + "', '" + address + "', '" + uname + "', '" + passwd + "')";
			
			int result = stmt.executeUpdate(sql);
			
			if (result != 0) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}

	// Method to retrieve a single user by username
	public static User getSingleUser(String uname) {
		User user = new User();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			// Select with additional fields (phone and address)
			String sql = "SELECT * FROM user WHERE uname='" + uname + "'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setPhone(rs.getString(4));      // Set phone number
				user.setEmail(rs.getString(5));
				user.setAddress(rs.getString(6));    // Set address
				user.setUname(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	// Method to list all users
	public static ArrayList<User> listUser() {
		ArrayList<User> list = new ArrayList<User>();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			// Select with additional fields (phone and address)
			String sql = "SELECT * FROM user";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				User user = new User();
				
				user.setId(rs.getInt(1));
				user.setFname(rs.getString(2));
				user.setLname(rs.getString(3));
				user.setPhone(rs.getString(4));      // Set phone number
				user.setEmail(rs.getString(5));
				user.setAddress(rs.getString(6));    // Set address
				user.setUname(rs.getString(7));
				
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	// Method to update user details
	public static boolean updateUser(int id, String fname, String lname, String phone, String address) {
		boolean success = false;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			// Update query with additional fields (phone and address)
			String sql = "UPDATE user SET fname='" + fname + "', lname='" + lname + "', phone='" + phone + "', address='" + address + "' WHERE id='" + id + "'";
			int rs = stmt.executeUpdate(sql);
			
			if (rs != 0) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}

	// Method to delete a user by ID
	public static void deleteUser(int id) {
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "DELETE FROM user WHERE id='" + id + "'";
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Method to authenticate user login
	public static boolean login(String uname, String passwd) {
		boolean success = false;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			
			String sql = "SELECT passwd FROM user WHERE uname='" + uname + "'";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				if (passwd.equals(rs.getString(1))) {
					success = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return success;
	}
}
