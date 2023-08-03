package com.cts.cms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.cms.dao.MenuItemsSpringJdbcImpl;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.MenuItems;

@ExtendWith(MockitoExtension.class)
class MenuItemsServiceImplTest {

	@Mock
	private MenuItemsSpringJdbcImpl menuItemsSpringJdbcImpl;

	@InjectMocks
	private MenuItemsServiceImpl menuItemsServiceImpl;


	@Test
	void testGetAllUser() throws SystemException {
		List<MenuItems> menuItems = List.of(new MenuItems(15,"Pizza", 150.00f));

		when(menuItemsSpringJdbcImpl.getAllItems()).thenReturn(menuItems);
		assertEquals(menuItemsServiceImpl.getAllItems().size(), 1);
	}

}
