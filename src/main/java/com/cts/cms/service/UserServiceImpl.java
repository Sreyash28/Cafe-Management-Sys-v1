package com.cts.cms.service;

import java.util.List;
import java.util.Optional;

import com.cts.cms.dao.UserDao;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getAllUser() throws SystemException {
		return userDao.getAllUser();
	}

	@Override
	public Optional<User> getUserById(int id) throws SystemException {
		Optional<User> optionalUser = userDao.getUserById(id);

		if (optionalUser.isEmpty()) {
			throw new SystemException("User not Exists with id: " + id);
		}
		return Optional.of(optionalUser.get());
	}

	@Override
	public boolean createUser(User user) throws SystemException {

		return userDao.createUser(user);
	}

	@Override
	public int loginUser(String name, String password) throws SystemException {
		int userflag = 0;
		List<User> users = userDao.getAllUser();
		for (User user : users) {
			if (user.getUserName().equals(name) && user.getPassword().equals(password)) {
				userflag = user.getId();
			}
		}
		return userflag;
	}

}
