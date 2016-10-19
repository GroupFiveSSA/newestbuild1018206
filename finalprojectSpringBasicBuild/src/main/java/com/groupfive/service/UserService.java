package com.groupfive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.groupfive.dao.IUserDAO;
import com.groupfive.entity.User;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;
	
	
	@Override
	public User getUserById(int userId) {
		User obj = userDAO.getUserById(userId);
		return obj;
	}
	
	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public synchronized boolean addUser(User user) {
		userDAO.addUser(user);
		return true;
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
		
	}

	@Override
	public void deleteUser(int userId) {
		userDAO.deleteUser(userId);
		
	}
	
	@Override
	public List<User> verifyPassword( String userEmail, String password){
		return userDAO.verifyPassword(userEmail, password);
	}

}