package com.vastika.uis.service;

import java.util.List;

import com.vastika.uis.dao.UserDao;
import com.vastika.uis.dao.UserDaoImpl;
import com.vastika.uis.model.User;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public int saveUserInfo(User user) {
		return userDao.saveUserInfo(user);
		
		
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUserInfo(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		// TODO Auto-generated method stub
		return userDao.getAllUserInfo();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	

}
