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

import com.cts.skynews.bean.Language;

@Component
public class LanguageDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	@Transactional
	public List<Language> fetchAllLanguage() {
		LOGGER.info("Start : Inside fetchAllLanguage() of LanguageDao");

		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<Language> languages = (List<Language>) session.createQuery("from Language").getResultList();
		session.close();
		LOGGER.info("END : Inside fetchAllLanguage() of LanguageDao");
		return languages;
	}
}
