package com.dady.cloud.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dady.cloud.server.model.User;
import com.dady.cloud.server.service.UserService;

@RestController
@RequestMapping(value = "/user")

public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserByName/{userName}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserByName(@PathVariable String userName) {
		return userService.findUserByName(userName);
	}
}
