package com.airline.service;

import java.sql.SQLException;
import java.util.Optional;

import com.airline.dao.UserDao;
import com.airline.entity.User;
import com.airline.exception.ResourceAlreadyExistException;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() throws SQLException{
		userDao = new UserDao();
	}
	
	public boolean registerUser(String name,String email,String password) {
		boolean status = false;
		Optional<User> foundUser = userDao.findAll().stream()
		.filter(user -> user.getEmail().equalsIgnoreCase(email))
		.findFirst();
		
		if(foundUser.isPresent()) {
			throw new ResourceAlreadyExistException("User Already created with same Email");
		}
		boolean isSaved =userDao.save(new User(0,name,email,password));
		if(isSaved) {
			System.out.println("User registered Successfully");
			status = true;
		}
		else {
			System.out.println("Failed to registered user!!");
		}
		return status;
	}
	public User loginUser(String email, String password) {
		return userDao.searchUserByEmailAndPassword(email, password);
		
	}
}
