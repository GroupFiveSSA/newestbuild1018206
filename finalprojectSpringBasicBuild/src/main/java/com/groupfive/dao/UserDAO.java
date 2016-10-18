package com.groupfive.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.groupfive.entity.User;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
	private HibernateTemplate  hibernateTemplate;

	@Override
	public User getUserById(int userId) {
		return hibernateTemplate.get(User.class, userId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as u ORDER BY u.userId";
		return (List<User>) hibernateTemplate.find(hql);
	}

	@Override
	public boolean addUser(User user) {
		hibernateTemplate.save(user);
		return true;
	}
	
	@Override
	public void updateUser(User user) {
		User record = getUserById(user.getUserId());
		
		record.setFirstName(user.getFirstName());
		record.setLastName(user.getLastName());
		record.setEmail(user.getEmail());
		record.setAddressline1(user.getAddressline1());
		record.setAddressline2(user.getAddressline2());
		record.setCity(user.getCity());
		record.setState(user.getState());
		record.setZipcode(user.getZipcode());
		record.setPassword(user.getPassword());
		
		hibernateTemplate.update(record);
	}
	
	@Override
	public void deleteUser(int userId){
		hibernateTemplate.delete(getUserById(userId));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> verifyPassword(String userEmail, String password){
		String hql = "FROM User where email = '" + userEmail + "'";
		return (List<User>) hibernateTemplate.find(hql);
	}
	

}
