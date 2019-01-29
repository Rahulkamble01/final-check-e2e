package com.cts.skynews.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cts.skynews.bean.Article;

@Component
public class ArticleDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	@Transactional
	public void save(Article article) {
		LOGGER.info("Start:save() of ArticleDao class ");
		Session session = sessionFactory.openSession();
		session.save(article);
		LOGGER.debug("User is :{}", article);
		session.close();
		LOGGER.info("End : :save() of ArticleDao class ");
	}
	
	@Transactional
	public Article findArticleByTitle(String title) {
		LOGGER.info("Start : Inside findArticleByTitle() of ArticleDao");
		Article article= null;
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Article> articles = (List<Article>) session.createQuery("from Article a where a.title = :title")
				.setParameter("title", title).list();
		if (articles.size() > 0) {
			article = articles.get(0);
			LOGGER.debug("User object {}", article);
		}
		session.close();
		LOGGER.info("END : Inside findArticleByTitle() of ArticleDao");
		return article;
	}

}
