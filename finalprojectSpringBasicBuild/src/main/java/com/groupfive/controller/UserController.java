package com.groupfive.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.servlet.ModelAndView;

import com.groupfive.entity.User;
import com.groupfive.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id){
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/user", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/user", method = RequestMethod.POST)
	public ResponseEntity<Void> userPerson(@RequestBody User user, UriComponentsBuilder builder) {
		boolean flag = userService.addUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getUserId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.PUT )
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> User(@PathVariable("id") Integer userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	//opens session for user login
	@RequestMapping(value="/userLogin", method = RequestMethod.POST )
	public ModelAndView userLoginPlus(@ModelAttribute User member, HttpSession sessionObj, ModelAndView mv){
	mv.setViewName("home1");
	List<User> success = userService.verifyPassword(member.getEmail(), member.getPassword());
	
		if(success.size() == 0){
			
			sessionObj.setAttribute("error", "Username not found");
			return mv;
			
		}
		
		String isValid = member.getPassword();
		if(!(success.get(0).getPassword().equals(isValid))){
			
			
			sessionObj.setAttribute("error", "Username or password invalid!");
			
			return mv;
			
			}else{
				
				
				sessionObj.setAttribute("user", success.get(0));
				mv.setViewName("PostLoginPageforWidgets");
				
				return mv;
				
			}
		
	}
	
	@RequestMapping(value="/userLogout")
	public ModelAndView userLogout(HttpSession sessionObj, ModelAndView mv){
		mv.setViewName("home1");
		sessionObj.invalidate();
		return mv;
	}
	
	
	
	
	

}
