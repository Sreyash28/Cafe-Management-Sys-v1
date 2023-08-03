package com.cts.cms.dao;

import java.util.List;
import java.util.Optional;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.User;

public interface UserDao {

	List<User> getAllUser() throws SystemException;

	public Optional<User> getUserById(int id) throws SystemException;

	boolean createUser(User user) throws SystemException;
}
