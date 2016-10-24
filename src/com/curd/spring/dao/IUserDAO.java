package com.curd.spring.dao;

import java.util.List;

import com.curd.spring.vo.User;

public interface IUserDAO {
	public void addUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public String searchUserName(int id);
	public User searchUser(int id);
	public List<User> findAll();
}
