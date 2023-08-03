package com.cts.cms.service;

import java.util.List;
import java.util.Optional;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.User;

public interface UserService {
	List<User> getAllUser() throws SystemException;

	public Optional<User> getUserById(int id) throws SystemException;

	 public boolean createUser(User user) throws SystemException;

	int loginUser(String name, String password) throws SystemException;
}
