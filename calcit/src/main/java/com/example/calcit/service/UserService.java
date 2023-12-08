package com.example.calcit.service;

import java.util.List;

import com.example.calcit.model.User;

public interface UserService {

    public void saveOrUpdate(User user);

	public void delete(int id);
    
    public User get(int id);

	public List<User> getAllUsers();

	public List<User> getUser(int id);

	public int checkLogin(String email, String password);
}
