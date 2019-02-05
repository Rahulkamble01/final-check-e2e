package com.cts.skynews.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.skynews.bean.BlockStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.service.UserService;

@RestController
@RequestMapping("/rest/admin")
public class AdminController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private UserService userService;

	
	@GetMapping("/search/{emailId}")
	public User serachUserByEmail(@PathVariable String emailId) {
		LOGGER.info("START : Inside serachUserByEmail() method of AdminController");
		LOGGER.debug("EmailId :  {}", emailId);
		LOGGER.info("END : Inside serachUserByEmail() method of AdminController");
		return userService.findUserByEmail(emailId);
	}

	@PostMapping("/block")
	public BlockStatus blockUser(@RequestBody User user) {
		LOGGER.info("START : Inside blockUser() method of AdminController");
		LOGGER.debug("User :  {}", user);
		LOGGER.info("END : Inside blockUser() method of AdminController");
		return userService.blockUser(user);
	}
}
