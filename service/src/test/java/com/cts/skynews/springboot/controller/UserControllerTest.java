package com.cts.skynews.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserControllerTest.class);

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void addNewUser() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"kirasln@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.signedUp").value("true"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}

	@Test
	public void checkEmailExists() throws Exception {
		LOGGER.info("START : Inside Spring Boot checkEmailExists() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"ravariakiran@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.emailExists").value("true"))
				.andExpect(jsonPath("$.signedUp").value("false"));

		LOGGER.info("END : Spring Boot checkEmailExists() method of UserController");

	}

	@Test
	public void incorrectEmailFormat() throws Exception {
		LOGGER.info("START : Inside Spring Boot incorrectEmailFormat() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"rgmail.com\"," + "\"password\":\"A123456\","
				+ "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Email address is invalid"));
		LOGGER.info("END : Spring Boot incorrectEmailFormat() method of UserController");
	}

	@Test
	public void nullName() throws Exception {
		LOGGER.info("START : Inside Spring Boot nullName() method of UserController");

		String USER_DATA = "{\"email\":\"abcdefg@gmail.com\"," + "\"password\":\"A123456\"," + "\"status\":\"active\","
				+ "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Name cannot be empty"));

		LOGGER.info("END : Spring Boot nullName() method of UserController");
	}

	@Test
	public void nullPassword() throws Exception {
		LOGGER.info("START : Inside Spring Boot nullPassword() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"abcdefg@gmail.com\","
				+ "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Password cannot be empty"));

		LOGGER.info("END : Spring Boot nullPassword() method of UserController");
	}

	@Test
	public void nullEmail() throws Exception {
		LOGGER.info("START : Inside Spring Boot nullEmail() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"password\":\"A123456\"," + "\"status\":\"active\","
				+ "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Email cannot be empty"));

		LOGGER.info("END : Spring Boot nullEmail() method of UserController");
	}

	@Test
	public void nullStatus() throws Exception {
		LOGGER.info("START : Inside Spring Boot nullEmail() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"abcdefg@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Status cannot be empty"));

		LOGGER.info("END : Spring Boot nullStatus() method of UserController");
	}

	@Test
	public void langugaeNull() throws Exception {
		LOGGER.info("START : Inside Spring Boot langugaeNull() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"abcdefg@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"status\":\"active\"," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Language cannot be empty"));

		LOGGER.info("END : Spring Boot langugaeNull() method of UserController");
	}

	@Test
	public void roleNull() throws Exception {
		LOGGER.info("START : Inside Spring Boot roleNull() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"abcdefg@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Role cannot be empty"));

		LOGGER.info("END : Spring Boot roleNull() method of UserController");
	}

	@Test
	public void invalidNameLength() throws Exception {
		LOGGER.info("START : Inside Spring Boot invalidNameLength() method of UserController");

		String USER_DATA = "{\"name\":\"KiranKiranRavariyKiranKiranRavariyaRRavariyaRavariyaRavariyaRavariyaRavariya "
				+ "KiranKiranRavariyKiranKiranRavariyaRRavariyaRavariyaRavariyaRavariyaRavariya "
				+ "KiranKiranRavariyKiranKiranRavariyaRRavariyaRavariyaRavariyaRavariyaRavariya\","
				+ "\"email\":\"abcdefg@gmail.com\"," + "\"password\":\"A123456\"," + "\"status\":\"active\","
				+ "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";

		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Name must be 3 to 80 characters"));

		LOGGER.info("END : Spring Boot invalidNameLength() method of UserController");

	}

	@Test
	public void invalidEmailLength() throws Exception {
		LOGGER.info("START : Inside Spring Boot invalidEmailLength() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\","
				+ "\"email\":\"ravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmailravariakiran@gmail.com\","
				+ "\"password\":\"A123456\"," + "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"},"
				+ "\"role\":{\"id\":1}}";

		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Input Validation Failed:Email must be 4 to 80 characters"));

		LOGGER.info("END : Spring Boot invalidEmailLength() method of UserController");

	}

	@Test
	public void incorrectPasswordFormat() throws Exception {
		LOGGER.info("START : Inside Spring Boot incorrectPasswordFormat() method of UserController");

		String USER_DATA = "{\"name\":\"Kiran Ravariya\"," + "\"email\":\"abcdefg@gmail.com\"," + "\"password\":\"12\","
				+ "\"status\":\"active\"," + "\"language\":{\"id\":\"1\"}," + "\"role\":{\"id\":1}}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/signup").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.errorMessage")
						.value("Input Validation Failed:Password must be 6 to 45 characters"));

		LOGGER.info("END : Spring Boot incorrectPasswordFormat() method of UserController");
	}

	@Test
	public void successfullLogin() throws Exception {
		LOGGER.info("START : Inside Spring Boot successfullLogin() method of UserController");

		String USER_DATA = "{\"email\":\"kiran@gmail.com\",\"password\":\"A123456\"}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/login").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value("true"));

		LOGGER.info("END : Spring Boot successfullLogin() method of UserController");
	}

	@Test
	public void invalidEmailForLogin() throws Exception {
		LOGGER.info("START : Inside Spring Boot invalidEmailForLogin() method of UserController");

		String USER_DATA = "{\"email\":\"kiran123@gmail.com\",\"password\":\"A123456\"}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/login").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value("false"));

		LOGGER.info("END : Spring Boot invalidEmailForLogin() method of UserController");
	}

	@Test
	public void invalidPasswordForLogin() throws Exception {
		LOGGER.info("START : Inside Spring Boot invalidPasswordForLogin() method of UserController");

		String USER_DATA = "{\"email\":\"kiran@gmail.com\",\"password\":\"12345678\"}";
		LOGGER.debug("JSON Object :  {}", USER_DATA);

		mockMvc.perform(post("/user/login").content(USER_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value("false"));;

		LOGGER.info("END : Spring Boot invalidPasswordForLogin() method of UserController");
	}

}
