package com.cts.skynews.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.skynews.bean.Article;
import com.cts.skynews.bean.ArticleStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.dao.ArticleDao;
import com.cts.skynews.dao.UserDao;



@Service
public class ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Autowired
	private UserDao userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	@SuppressWarnings("unchecked")
	public ArticleStatus saveArticle(Article article) {
		LOGGER.info("START : Inside saveArticle() method of UserService");
		LOGGER.debug("Article Object :  {}", article);
		ArticleStatus status = new ArticleStatus();
		status.setSaved(false);
		status.setArticleExists(false);

		Article actualArticle = articleDao.findArticleByTitle(article.getTitle());

		if (actualArticle != null) {
			status.setArticleExists(true);
			LOGGER.info("Article Exists !!");
		}
		if (!status.isArticleExists()) {
			articleDao.save(article);
								
			User user = userDao.findUserByEmail(article.getEmail());
			user.getArticles().add(article);
			userDao.save(user);
			status.setSaved(true);
			LOGGER.info("Article Saved !!");
			
		}
		return status;
	}
}
