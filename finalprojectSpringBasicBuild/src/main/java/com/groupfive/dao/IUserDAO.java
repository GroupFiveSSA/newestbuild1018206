package com.groupfive.dao;

import java.util.List;
import com.groupfive.entity.User;

public interface IUserDAO {
	
	List<User> getAllUsers();
	User getUserById(int userId);
	boolean addUser(User user);
	void updateUser(User user);
	void deleteUser(int userId);
	List<User> verifyPassword(String userEmail, String password);

}