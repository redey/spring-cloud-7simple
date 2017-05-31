package com.dady.cloud.ui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dady.cloud.ui.model.User;
import com.dady.cloud.ui.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping(value="/getUserByName")

	public ResponseEntity <User> getUserByName(String userName){
		User user = userService.findUserByName(userName);
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/getAllUsers")

	public ResponseEntity <List<User>> getAllUsers(){
		List<User> users;
		try {
			users = userService.getAllUsers();
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
