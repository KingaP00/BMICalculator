package com.example.calcit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.calcit.dao.UserDao;
import com.example.calcit.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void delete(int id) {
		userDao.delete(id);

	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public List<User> getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);

	}

	@Override
	public boolean checkLogin(int userId, String password) {
		return userDao.checkLogin(userId, password);
	}
}
