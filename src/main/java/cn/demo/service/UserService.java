package cn.demo.service;

import cn.demo.dao.UserDao;

public class UserService {
	private UserDao dao;

	public UserService() {
		System.out.println("UserService constructor-----------------");
	}
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
	public void say() {
		dao.say();
	}
}
