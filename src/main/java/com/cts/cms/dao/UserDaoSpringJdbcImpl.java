package com.cts.cms.dao;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.User;

public class UserDaoSpringJdbcImpl implements UserDao {
	private static final String Find_All_User = "select * from users";
	private static final String Find_User_By_Id = "select * from users where id=?";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getAllUser() throws SystemException {
		return jdbcTemplate.query(Find_All_User, (rs, no) -> new User(rs.getInt("id"), rs.getString("userName"),
				rs.getString("contactNumber"), rs.getString("email"), rs.getString("password"), rs.getString("role")));
	}

	@Override
	public Optional<User> getUserById(int id) throws SystemException {
		// TODO Auto-generated method stub
		return Optional.of(jdbcTemplate.queryForObject(Find_User_By_Id, new UserMapper(), id));
	}

	@Override
	public boolean createUser(User user) throws SystemException {
		String create_User = "insert into users (id, userName, contactNumber, email, password, role) values (?,?, ?, ?, ?, ?)";

		int rowsAffected = jdbcTemplate.update(create_User, user.getId(), user.getUserName(), user.getContactNumber(),
				user.getEmail(), user.getPassword(), user.getRole());
		if (rowsAffected > 0) {
			System.out.println("New user created successfully");
			return true;
		} else {
			return false;
		}

	}
	

}
