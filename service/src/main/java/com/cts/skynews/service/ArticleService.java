package com.cts.skynews.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.skynews.bean.Article;
import com.cts.skynews.bean.ArticleStatus;
import com.cts.skynews.bean.User;
import com.cts.skynews.repository.ArticleRepository;
import com.cts.skynews.repository.UserRepository;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	// private ArticleDao articleDao;

	@Autowired
	private UserRepository userRepository;
	// private UserDao userDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	public ArticleStatus saveArticle(Article article) {
		LOGGER.info("START : Inside saveArticle() method of ArticleService");
		LOGGER.debug("Article Object :  {}", article);
		ArticleStatus status = new ArticleStatus();
		status.setSaved(false);
		status.setArticleExists(false);
		status.setMarkedFavourite(false);

		Article actualArticle = articleRepository.findArticleByTitle(article.getTitle());

		if (actualArticle != null) {
			status.setArticleExists(true);
			LOGGER.info("Article Exists !!");
		}
		// Save the article to DB and Mark as Favorite.
		if (!status.isArticleExists()) {
			articleRepository.save(article);
			LOGGER.info("Article is Saved !!");
			User user = userRepository.findUserByEmail(article.getEmail());
			LOGGER.debug("User Object : {}", user);
			user.getArticles().add(article);
			LOGGER.info("Added to List of article now Saving as Favourite !!");
			userRepository.save(user);
			status.setSaved(true);
			status.setMarkedFavourite(true);
			LOGGER.info("Article Marrked as Favourite !!");

		}
		// If article is already present then mark as favorite only if it is
		// never been marked by that user.
		if (status.isArticleExists()) {
			User user = userRepository.findUserByEmail(article.getEmail());
			LOGGER.debug("User Object : {}", user);
			List<Article> articleList = user.getArticles();
			if (articleList.size() > 0) {
				LOGGER.info("Few articles are there checking if it is already marked!!");
				for (Article existingArticle : articleList) {
					if (existingArticle.getTitle().equals(actualArticle.getTitle())) {
						status.setMarkedFavourite(true);
						LOGGER.info("Article is already marked as Favourite !!");
						return status;
					} else {
						LOGGER.info("Article is never  marked as Favourite By this User!!");
						user.getArticles().add(actualArticle);
						LOGGER.info("Added to List of article now Saving as Favourite !!");
						userRepository.save(user);
						status.setMarkedFavourite(true);
						LOGGER.info("Article Marrked as Favourite !!");
						return status;
					}
				}
			} else {
				LOGGER.info("Article is never  marked as Favourite By this User!!");
				user.getArticles().add(actualArticle);
				LOGGER.info("Added to List of article now Saving as Favourite !!");
				userRepository.save(user);
				status.setMarkedFavourite(true);
				LOGGER.info("Article Marrked as Favourite !!");
			}
		}
		LOGGER.info("--------------------------------- !!");
		return status;
	}

	public User fetchAllFavArticles(String emailId) {
		LOGGER.info("START : Inside fetchAllFavArticles() method of ArticleService");
		LOGGER.debug("Email Id:  {}", emailId);
		LOGGER.info("END : Inside fetchAllFavArticles() method of ArticleService");
		return userRepository.findUserByEmail(emailId);
	}

	public User reomveFavouredMark(Article article) {
		LOGGER.info("START : Inside reomveFavouredMark() method of ArticleService");
		LOGGER.debug("Article Object :  {}", article);
		LOGGER.debug("Article Title : from Artilce List : {}", article.getTitle());
		User user = userRepository.findUserByEmail(article.getEmail());
		LOGGER.debug("user Object :  {}", user);
		List<Article> articles = user.getArticles();
		for (int i = 0; i < articles.size(); i++) {
			LOGGER.info("Iterating through article List and searching aeticle by title.!!");
			LOGGER.debug("Article Title from Artilce List : {}", articles.get(i).getTitle());

			if (articles.get(i).getTitle().equals(article.getTitle())) {
				articles.remove(i);
				LOGGER.info("Article found and removed from the List.");
				break;
			}
		}
		LOGGER.info("Saving User Object");
		return userRepository.save(user);

	}
}
