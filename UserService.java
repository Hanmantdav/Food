package services;

import java.sql.SQLException;

import dao.UserDao;
import dto.UserDTO;

public class UserService 
{
	public String createUser(UserDTO userDto) {
		UserDao createUserDao = new UserDao();
		try {
			return createUserDao.createUser(userDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "";
	}
	public String userLogin(UserDTO userDto) {
		UserDao createUserDao = new UserDao();
		try {
			return createUserDao.userLogin(userDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "";
	}

}
