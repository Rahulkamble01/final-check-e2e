package com.cts.skynews.mockito.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.skynews.bean.AuthenticationStatus;
import com.cts.skynews.bean.SignUpStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.dao.UserDao;
import com.cts.skynews.repository.UserRepository;
import com.cts.skynews.service.UserService;

public class UserServiceTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

	@Mock
	UserRepository mockedUserRepository;
	// UserDao mockedUserDao;

	@InjectMocks
	UserService service;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void signUpNewUser() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("kiran@gmail.com");
		LOGGER.debug("User Object :  {}", user);
		when(mockedUserRepository.findUserByEmail(user.getEmail())).thenReturn(null);

		SignUpStatus expectedStatus = new SignUpStatus(true, false);
		SignUpStatus actualStatus = service.addUser(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		verify(mockedUserRepository, times(1)).save(Mockito.any(User.class));
		verify(mockedUserRepository, times(1)).findUserByEmail(user.getEmail());

		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}

	@Test
	public void emailAlreadyExists() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("kiran@gmail.com");
		LOGGER.debug("User Object :  {}", user);
		when(mockedUserRepository.findUserByEmail(user.getEmail())).thenReturn(user);

		SignUpStatus expectedStatus = new SignUpStatus(false, true);
		SignUpStatus actualStatus = service.addUser(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		verify(mockedUserRepository, times(0)).save(Mockito.any(User.class));
		verify(mockedUserRepository, times(1)).findUserByEmail(user.getEmail());

		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}

	@Test
	public void loginValidUser() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("kiran@gmail.com");
		user.setPassword("123456");
		LOGGER.debug("User Object :  {}", user);
		when(mockedUserRepository.findUserByEmail(user.getEmail())).thenReturn(user);

		AuthenticationStatus expectedStatus = new AuthenticationStatus();
		expectedStatus.setAuthenticated(true);
		expectedStatus.setActualUser(user);
		AuthenticationStatus actualStatus = service.loginUser(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		verify(mockedUserRepository, times(0)).save(Mockito.any(User.class));
		verify(mockedUserRepository, times(1)).findUserByEmail(user.getEmail());

		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}

	@Test
	public void testLoginForInvalidEmail() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("kiran@gmail.com");
		user.setPassword("123456");
		LOGGER.debug("User Object :  {}", user);

		AuthenticationStatus expectedStatus = new AuthenticationStatus();
		expectedStatus.setAuthenticated(false);
		expectedStatus.setActualUser(null);

		User actualUser = new User();
		actualUser.setEmail("kiran.com");
		actualUser.setPassword("123456");

		when(mockedUserRepository.findUserByEmail(user.getEmail())).thenReturn(actualUser);

		AuthenticationStatus actualStatus = service.loginUser(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		
		verify(mockedUserRepository, times(1)).findUserByEmail(user.getEmail());

		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}
	
	@Test
	public void testLoginForInvalidPassword() {
		LOGGER.info("START : Inside Unit Testing addUser() method of UserServiceTest");
		User user = new User();
		user.setEmail("kiran@gmail.com");
		user.setPassword("123456");
		LOGGER.debug("User Object :  {}", user);

		AuthenticationStatus expectedStatus = new AuthenticationStatus();
		expectedStatus.setAuthenticated(false);
		expectedStatus.setActualUser(null);

		User actualUser = new User();
		actualUser.setEmail("kiran@gmail.com");
		actualUser.setPassword("1256");

		when(mockedUserRepository.findUserByEmail(user.getEmail())).thenReturn(actualUser);

		AuthenticationStatus actualStatus = service.loginUser(user);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		
		verify(mockedUserRepository, times(1)).findUserByEmail(user.getEmail());

		LOGGER.info("End : Unit Testing addUser() method of UserServiceTest");
	}

}
