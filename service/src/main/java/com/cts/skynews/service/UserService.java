package com.cts.skynews.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.skynews.bean.AuthenticationStatus;
import com.cts.skynews.bean.SignUpStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public SignUpStatus addUser(User user) {
		LOGGER.info("START : Inside addUser() method of UserService");
		LOGGER.debug("User Object :  {}", user);
		SignUpStatus signUpStatus = new SignUpStatus();
		signUpStatus.setEmailExists(false);
		signUpStatus.setSignedUp(false);
		LOGGER.debug("Email Id from client :  {}", user.getEmail());

		User actualUserEmail = userDao.findUserByEmail(user.getEmail());

		if (actualUserEmail != null) {
			LOGGER.info("Email Already Exists");
			signUpStatus.setEmailExists(true);
		}

		if (!signUpStatus.isEmailExists()) {
			userDao.save(user);
			signUpStatus.setSignedUp(true);
			LOGGER.info("User Signed Up ");
		}

		return signUpStatus;
	}

	public AuthenticationStatus login(User user) {
		LOGGER.info("START : Inside login() method of UserService");
		LOGGER.debug("User Object :  {}", user);
		String userEmail = user.getEmail();
		String userPasssword = user.getPassword();

		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		status.setAdmin(false);
		status.setAccountStatus(false);
		User actualUser = userDao.findUserByEmail(userEmail);

		if (actualUser != null) {
			String actualPassword = actualUser.getPassword();
			String actualEmail = actualUser.getEmail();

			if (actualPassword.equals(userPasssword) && userEmail.equals(actualEmail)) {
				status.setAuthenticated(true);
			}

			if (status.isAuthenticated() && actualUser.getRole().getDescription().equals("admin")) {
				status.setAdmin(true);
			}

			if (status.isAuthenticated() && actualUser.getStatus().equals("active")) {
				status.setAccountStatus(true);
			}
		}
		return status;
	}
}
