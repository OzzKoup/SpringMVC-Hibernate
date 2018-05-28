package com.project.repository;

import java.util.List;

import com.project.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;
	public User save(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user;
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	public List<User> getAll() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public User getById(Integer id) {
		User user = sessionFactory.getCurrentSession().get(User.class, id);
		return user;
	}
}
