package com.dady.cloud.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dady.cloud.server.dao.UserDao;
import com.dady.cloud.server.model.User;
@Service
public class UserService {
	@Autowired
	UserDao userDao;
	public User findUserByName(String userName){
		return userDao.findUserByName(userName);
	}
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.findAllUsers();
	}
}
