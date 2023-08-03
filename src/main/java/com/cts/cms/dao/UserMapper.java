package com.cts.cms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.cms.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(rs.getInt("id"), rs.getString("userName"), rs.getString("contactNumber"),
				rs.getString("email"), rs.getString("password"), rs.getString("role"));
		return user;
	}

}
