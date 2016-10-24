package com.curd.spring.test;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.curd.spring.dao.IUserDAO;
import com.curd.spring.vo.User;

public class UserTest {

	//增
	public void demo1() {
		User user = new User();
		user.setId(3);
		user.setUsername("admin");
		user.setPassword("123456");
		user.setClassroom("806");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO dao = (IUserDAO) applicationContext.getBean("userDao");
		dao.addUser(user);
	}
	//删
	public void demo2() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO dao = (IUserDAO) applicationContext.getBean("userDao");
		dao.deleteUser(2);
	}
	//改
	public void demo3() {
		User user = new User();
		user.setId(1);
		user.setUsername("admin");
		user.setPassword("admin");
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO dao = (IUserDAO) applicationContext.getBean("userDao");
		dao.updateUser(user);
	}
	//查（简单查询，返回字符串）
	public void demo4() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO dao = (IUserDAO) applicationContext.getBean("userDao");
		String name = dao.searchUserName(1);
		System.out.println(name);
	}
	//查（简单查询，返回对象)
	public void demo5() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO dao = (IUserDAO) applicationContext.getBean("userDao");
		User user = dao.searchUser(1);
		System.out.println(user.getUsername());
	}
	//查（复杂查询，返回对象集合）
	public void demo6() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDAO dao = (IUserDAO) applicationContext.getBean("userDao");
		User user = (User) dao.findAll();
		List<User> users = dao.findAll();
		System.out.println(users.size());
	}
}
