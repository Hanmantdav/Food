package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.UserDTO;

public class UserDao {

	public String createUser(UserDTO userDto) throws SQLException {
		Connection con = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "admin");
			String query = " insert into user (username, password) values (?, ?)";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, userDto.getUserName());
			preparedStmt.setString(2, userDto.getPassword());
			preparedStmt.execute();

		} catch (Exception e) {
			System.out.println("CreateUserDao | createUser" + e.getMessage());
			return "unsuccessful";
		} finally {
			con.close();
		}
		return "successful";
	}

	public String userLogin(UserDTO userDto) throws SQLException {
		Connection con = null;
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root", "admin");
			String query = " select * from user where username = ? and password =?";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, userDto.getUserName());
			preparedStmt.setString(2, userDto.getPassword());
			ResultSet rs = preparedStmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(2).equals(userDto.getUserName()) && rs.getString(3).equals(userDto.getPassword())) {
					return "successful";
				} else {
					return "unsuccessful";
				}
			}

		} catch (Exception e) {
			System.out.println("CreateUserDao | createUser" + e.getMessage());
			return "unsuccessful";
		} finally {
			con.close();
		}
		return "";
	}

}

