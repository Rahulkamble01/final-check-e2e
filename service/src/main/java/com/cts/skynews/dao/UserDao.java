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

import com.cts.skynews.bean.User;

@Component
public class UserDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(EntityManagerFactory emFactory) {
		this.sessionFactory = emFactory.unwrap(SessionFactory.class);
	}

	@Transactional
	public User findUserByEmail(String email) {
		LOGGER.info("Start : Inside findUserByEmail() of UserDao");
		User user = null;
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> users = (List<User>) session.createQuery("from User u where u.email = :email")
				.setParameter("email", email).getResultList();
		if (users.size() > 0) {
			user = users.get(0);
			LOGGER.debug("User object {}", user);
		}
		session.close();
		LOGGER.info("END : Inside findUserByEmail() of UserDao");
		return user;
	}

	@Transactional
	public void save(User user) {
		LOGGER.info("Start");
		Session session = sessionFactory.openSession();
		session.save(user);
		LOGGER.debug("User is :{}", user);
		session.close();
		LOGGER.info("End");
	}

}
