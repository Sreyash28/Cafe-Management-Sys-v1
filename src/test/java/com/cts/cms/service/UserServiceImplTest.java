/**
 * 
 */
package com.cts.cms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.cms.dao.UserDaoSpringJdbcImpl;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.User;

/**
 * @author sreyash
 *
 */

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	private UserDaoSpringJdbcImpl userDaoSpringJdbcImpl;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Test
	void testGetAllUser() throws SystemException {
		List<User> userList = List.of(new User(11, "sam", "8823152600", "sam2@gmail.com", "psam0", "user"));

		when(userDaoSpringJdbcImpl.getAllUser()).thenReturn(userList);
		assertEquals(userServiceImpl.getAllUser().size(), 1);
	}

	@Test
	void testGetUserById() throws SystemException {
		Optional<User> optional = Optional.of(new User(11, "sam", "8823152600", "sam2@gmail.com", "psam0", "user"));

		when(userDaoSpringJdbcImpl.getUserById(11)).thenReturn(optional);
		assertEquals(userServiceImpl.getUserById(11),optional);
	}

}
