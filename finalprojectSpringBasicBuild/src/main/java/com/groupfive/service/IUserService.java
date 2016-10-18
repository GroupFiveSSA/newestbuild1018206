package com.groupfive.service;

import java.util.List;

import com.groupfive.entity.User;


public interface IUserService {
	
	List<User> getAllUsers();
	User getUserById(int user_id);
	boolean addUser(User user);
	void updateUser(User user);
	void deleteUser(int user_id);
	List<User> verifyPassword(String userEmail, String password);

}
