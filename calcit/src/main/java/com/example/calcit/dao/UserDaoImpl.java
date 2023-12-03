package com.example.calcit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.calcit.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void delete(int id) {
		User user = (User) sessionFactory.getCurrentSession().load(User.class, id);
		if (null != user) {
			this.sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public User get(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return sessionFactory.getCurrentSession().createQuery("FROM user").list();
	}

	@Override
	public List<User> getUser(int id) {
		return sessionFactory
				.getCurrentSession()
				.createQuery("FROM user u WHERE u.userId=:id").setParameter("userId", id).list();
	}

	@SuppressWarnings("unchecked")
	public int checkLogin(String  email, String password) {
		int userid = -1;
		List<User> list = sessionFactory
				.getCurrentSession()
				.createQuery("FROM User as u WHERE u.email=:email AND u.password=:password")
				.setParameter("email", email)
				.setParameter("password", password).list();

		if ((list != null) && (list.size() > 0)) {
			userid = list.get(0).getUserId();
		}
		return userid;
	}

}
