package com.cts.skynews.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.skynews.bean.AuthenticationStatus;
import com.cts.skynews.bean.BlockStatus;
import com.cts.skynews.bean.SignUpStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	//private UserDao userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	public SignUpStatus addUser(User user) {
		LOGGER.info("START : Inside addUser() method of UserService");
		LOGGER.debug("User Object :  {}", user);
		SignUpStatus signUpStatus = new SignUpStatus();
		signUpStatus.setEmailExists(false);
		signUpStatus.setSignedUp(false);
		LOGGER.debug("Email Id from client :  {}", user.getEmail());

		User actualUserEmail = userRepository.findUserByEmail(user.getEmail());
		LOGGER.debug("actualUserEmail Object :  {}", actualUserEmail);
		if (actualUserEmail != null) {
			LOGGER.info("Email Already Exists");
			signUpStatus.setEmailExists(true);
		}

		if (!signUpStatus.isEmailExists()) {
			userRepository.save(user);
			signUpStatus.setSignedUp(true);
			LOGGER.info("User Signed Up ");
		}

		return signUpStatus;
	}

	public AuthenticationStatus loginUser(User user) {
		LOGGER.info("START : Inside loginUser() method of UserService");
		LOGGER.debug("User Object :  {}", user);
		String userEmail = user.getEmail();
		String userPasssword = user.getPassword();
		LOGGER.debug("User Email : {} ", userEmail + " User Passowrd :  {}", userPasssword);
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);

		User actualUser = userRepository.findUserByEmail(userEmail);

		if (actualUser != null) {
			String actualPassword = actualUser.getPassword();
			String actualEmail = actualUser.getEmail();
			LOGGER.debug("Actual Email : {} ", actualEmail + "Actual Passowrd :  {}", actualPassword);

			if (actualPassword.equals(userPasssword) && userEmail.equals(actualEmail)) {
				status.setAuthenticated(true);
				status.setActualUser(actualUser);
				LOGGER.debug("Actual User Object {}",actualUser);
				LOGGER.info("Login Successfull");
			}

		}
		LOGGER.info("END : loginUser() method of UserService");
		return status;
	}
	
	public User findUserByEmail(String emailId) {
		LOGGER.info("START : Inside findUserByEmail() method of UserService");
		LOGGER.debug("EmailId  :  {}", emailId);
		BlockStatus status = new BlockStatus();
		
		
		LOGGER.debug("Email Id from client :  {}", emailId);

		User user = userRepository.findUserByEmail(emailId);
		LOGGER.info("END : Inside findUserByEmail() method of UserService");
		return user;
	}
	
	public BlockStatus blockUser(User user) {
		LOGGER.info("START : Inside blockUser() method of UserService");
		LOGGER.debug("User  :  {}", user);
		BlockStatus status = new BlockStatus();
		status.setBlocked(false);
		
		user.setStatus("blocked");
		userRepository.save(user);
		status.setBlocked(true);
		LOGGER.info("User Blocked");
		return status;
	}
}
