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
public class ArticleControllerTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleControllerTest.class);

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void markArticleIfArticleisNew() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String ARTICLE_DATA = "{\"author\": null,\"title\": \"Test Articslse 2\","
				+ "\"description\": \"\",\"url\": \"httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607\","
				+ "   \"urlToImage\": \"httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503\","
				+ "\"publishedAt\": \"2019-02-04T07:22:00Z\","
				+ "\"content\": \"Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publica"
				+ "tions,like ours, are being forced to look for new ways to keep\","
				+ "\"email\": \"kiran@gmail.com\" }";
		LOGGER.debug("JSON Object :  {}", ARTICLE_DATA);

		mockMvc.perform(post("/article/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.saved").value("true"))
				.andExpect(jsonPath("$.articleExists").value("false"))
				.andExpect(jsonPath("$.markedFavourite").value("true"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}
	
	@Test
	public void markArticleIfArticleAlreadyExistsButNeverMarkedByUser() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String ARTICLE_DATA = "{\"author\": null,\"title\": \"Test Article 1\","
				+ "\"description\": \"\",\"url\": \"httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607\","
				+ "   \"urlToImage\": \"httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503\","
				+ "\"publishedAt\": \"2019-02-04T07:22:00Z\","
				+ "\"content\": \"Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publica"
				+ "tions,like ours, are being forced to look for new ways to keep\","
				+ "\"email\": \"abcd@gmail.com\" }";
		LOGGER.debug("JSON Object :  {}", ARTICLE_DATA);

		mockMvc.perform(post("/article/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.saved").value("false"))
				.andExpect(jsonPath("$.articleExists").value("true"))
				.andExpect(jsonPath("$.markedFavourite").value("true"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}
	
	@Test
	public void markArticleIfArticleAlreadyExistsAndAlreadyMarkedAsFavoriteByUser() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String ARTICLE_DATA = "{\"author\": null,\"title\": \"Test Article 2\","
				+ "\"description\": \"\",\"url\": \"httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607\","
				+ "   \"urlToImage\": \"httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503\","
				+ "\"publishedAt\": \"2019-02-04T07:22:00Z\","
				+ "\"content\": \"Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publica"
				+ "tions,like ours, are being forced to look for new ways to keep\","
				+ "\"email\": \"kiran@gmail.com\" }";
		LOGGER.debug("JSON Object :  {}", ARTICLE_DATA);

		mockMvc.perform(post("/article/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.saved").value("false"))
				.andExpect(jsonPath("$.articleExists").value("true"))
				.andExpect(jsonPath("$.markedFavourite").value("true"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}
	
	@Test
	public void titleNotNull() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String ARTICLE_DATA = "{\"author\": null,"
				+ "\"description\": \"\",\"url\": \"httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607\","
				+ "   \"urlToImage\": \"httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503\","
				+ "\"publishedAt\": \"2019-02-04T07:22:00Z\","
				+ "\"content\": \"Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publica"
				+ "tions,like ours, are being forced to look for new ways to keep\","
				+ "\"email\": \"kiran@gmail.com\" }";
		LOGGER.debug("JSON Object :  {}", ARTICLE_DATA);

		mockMvc.perform(post("/article/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Title cannot be empty"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}
	
	@Test
	public void descriptionNotNull() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String ARTICLE_DATA = "{\"author\": null,\"title\": \"Test Article  2\","
				 + "\"url\": \"httpswww.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607\","
				+ "   \"urlToImage\": \"httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503\","
				+ "\"publishedAt\": \"2019-02-04T07:22:00Z\","
				+ "\"content\": \"Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publica"
				+ "tions,like ours, are being forced to look for new ways to keep\","
				+ "\"email\": \"kiran@gmail.com\" }";
		LOGGER.debug("JSON Object :  {}", ARTICLE_DATA);

		mockMvc.perform(post("/article/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:Description cannot be empty"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}
	
	@Test
	public void urlNotNull() throws Exception {
		LOGGER.info("START : Inside Spring Boot addUser() method of UserController");

		String ARTICLE_DATA = "{\"author\": null,\"title\": \"Test Article  2\","
				 + "\"description\": \"\","
				+ "   \"urlToImage\": \"httpsimages.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503\","
				+ "\"publishedAt\": \"2019-02-04T07:22:00Z\","
				+ "\"content\": \"Dear Reader,As you can imagine, more people are reading The Jerusalem Post than ever before.Nevertheless, traditional business models are no longer sustainable and high-quality publica"
				+ "tions,like ours, are being forced to look for new ways to keep\","
				+ "\"email\": \"kiran@gmail.com\" }";
		LOGGER.debug("JSON Object :  {}", ARTICLE_DATA);

		mockMvc.perform(post("/article/save").content(ARTICLE_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Input Validation Failed:URL cannot be empty"));

		LOGGER.info("END : Spring Boot addUser() method of UserController");

	}
}
