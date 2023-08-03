package com.cts.cms.service;

import java.util.List;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.MenuItems;

public interface MenuItemsService {
	List<MenuItems> getAllItems() throws SystemException;

	public MenuItems getItemById(int id) throws SystemException;
}
