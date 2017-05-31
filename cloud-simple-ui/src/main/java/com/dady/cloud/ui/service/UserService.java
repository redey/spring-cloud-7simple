package com.dady.cloud.ui.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dady.cloud.ui.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {
	@Autowired
	RestTemplate restTemplate;
	final String SERVICE_NAME="cloud-simple-service";
	
	@HystrixCommand(fallbackMethod="fallbackSearchUser")
	public User findUserByName(String userName){
		return restTemplate.getForObject("http://"+SERVICE_NAME+"/user/getUserByName/"+userName, User.class);
	}
	
	
	private User fallbackSearchUser(String userName){
		System.out.println("HystrixCommand fallbackMethod handle!");
		User u = new User();
		u.setName("test");
		return u;
	}

	@HystrixCommand(fallbackMethod="fallbackSearchAllUsers")

	public List<User> getAllUsers() throws Exception {
		//throw new Exception("test");
		return restTemplate.getForObject("http://"+SERVICE_NAME+"/user/getAllUsers/", List.class);
	}
	
	private List<User> fallbackSearchAllUsers(){
		System.out.println("HystrixCommand fallbackSearchAllUsers handle!");
		User u = new User();
		u.setName("test111");
		List<User> users = new ArrayList<User>();
		users.add(u);
		return users;
	}
	
}
