package com.cts.skynews.mockito.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.skynews.bean.Article;
import com.cts.skynews.bean.ArticleStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.repository.ArticleRepository;
import com.cts.skynews.repository.UserRepository;
import com.cts.skynews.service.ArticleService;

public class ArticleServiceTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleServiceTest.class);

	@Mock
	ArticleRepository articleRepository;

	@Mock
	UserRepository userRepository;

	@InjectMocks
	ArticleService articleService;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void markNewArticleAsFavorite() {
		LOGGER.info("START : Inside Unit Testing addNewArticle() method of ArticleServiceTest");
		Article article = new Article();
		article.setTitle("Article from front End");
		article.setId(1);
		ArticleStatus expectedStatus = new ArticleStatus();
		expectedStatus.setArticleExists(false);
		expectedStatus.setSaved(true);
		expectedStatus.setMarkedFavourite(true);

		LOGGER.debug("Article Object :  {}", article);
		when(articleRepository.findArticleByTitle(article.getTitle())).thenReturn(null);
		when(articleRepository.save(article)).thenReturn(article);
		User user = new User();

		List<Article> articles = new ArrayList<Article>();
		articles.add(article);
		user.setArticles(articles);
		when(userRepository.findUserByEmail(article.getEmail())).thenReturn(user);

		ArticleStatus actualStatus = articleService.saveArticle(article);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		verify(articleRepository, times(1)).save(Mockito.any(Article.class));
		verify(userRepository, times(1)).findUserByEmail(user.getEmail());
		verify(userRepository, times(1)).save(Mockito.any(User.class));

		LOGGER.info("End : Unit Testing addNewArticle() method of ArticleServiceTest");
	}
	
	@Test
	public void markArticleIfAlreadyExistAndNeverMarkedFavourite() {
		LOGGER.info("START : Inside Unit Testing addNewArticle() method of ArticleServiceTest");
		Article article = new Article();
		article.setTitle("Article from front End");
		article.setId(1);
		ArticleStatus expectedStatus = new ArticleStatus();
		expectedStatus.setArticleExists(true);
		expectedStatus.setSaved(false);
		expectedStatus.setMarkedFavourite(true);

		LOGGER.debug("Article Object :  {}", article);
		when(articleRepository.findArticleByTitle(article.getTitle())).thenReturn(article);
		when(articleRepository.save(article)).thenReturn(article);
		User user = new User();

		Article existingArticle = new Article();
		existingArticle.setTitle("Existing Article");
		List<Article> articles = new ArrayList<Article>();
		articles.add(existingArticle);
		
		user.setArticles(articles);
		when(userRepository.findUserByEmail(article.getEmail())).thenReturn(user);

		ArticleStatus actualStatus = articleService.saveArticle(article);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		verify(articleRepository, times(0)).save(Mockito.any(Article.class));
		verify(userRepository, times(1)).findUserByEmail(user.getEmail());
		verify(userRepository, times(1)).save(Mockito.any(User.class));

		LOGGER.info("End : Unit Testing addNewArticle() method of ArticleServiceTest");
	}
	
	@Test
	public void markArticleIfAlreadyExistAndAlreadyMarkedFavourite() {
		LOGGER.info("START : Inside Unit Testing addNewArticle() method of ArticleServiceTest");
		Article article = new Article();
		article.setTitle("Article from front End");
		article.setId(1);
		ArticleStatus expectedStatus = new ArticleStatus();
		expectedStatus.setArticleExists(true);
		expectedStatus.setSaved(false);
		expectedStatus.setMarkedFavourite(true);

		LOGGER.debug("Article Object :  {}", article);
		when(articleRepository.findArticleByTitle(article.getTitle())).thenReturn(article);
		when(articleRepository.save(article)).thenReturn(article);
		User user = new User();

		
		List<Article> articles = new ArrayList<Article>();
		articles.add(article);
		
		user.setArticles(articles);
		when(userRepository.findUserByEmail(article.getEmail())).thenReturn(user);

		ArticleStatus actualStatus = articleService.saveArticle(article);

		LOGGER.debug("Expected  Output :  {}", expectedStatus);
		LOGGER.debug("Actual  Output :  {}", actualStatus);

		Assert.assertEquals(true, expectedStatus.equals(actualStatus));
		verify(articleRepository, times(0)).save(Mockito.any(Article.class));
		verify(userRepository, times(1)).findUserByEmail(user.getEmail());
		verify(userRepository, times(0)).save(Mockito.any(User.class));

		LOGGER.info("End : Unit Testing addNewArticle() method of ArticleServiceTest");
	}

}
