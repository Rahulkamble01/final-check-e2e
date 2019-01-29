package com.cts.skynews.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.skynews.bean.AuthenticationStatus;
import com.cts.skynews.bean.SignUpStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController  extends SkyNewsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/signup")
	public SignUpStatus addUser(@RequestBody User user) {
		LOGGER.info("START : Inside addUser() method of UserController");
		LOGGER.debug("User Object :  {}", user);

		return userService.addUser(user);
	}
	
	@PostMapping("/login")
	public AuthenticationStatus login(@RequestBody User user) {
		LOGGER.info("START : Inside addUser() method of UserController");
		LOGGER.debug("User Object :  {}", user);

		return userService.loginUser(user);
	}
}
