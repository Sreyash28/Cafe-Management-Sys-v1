package com.cts.cms.service;

import java.util.List;
import java.util.Optional;

import com.cts.cms.dao.MenuItemsDao;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.MenuItems;


public class MenuItemsServiceImpl implements MenuItemsService {

	private MenuItemsDao menuItemsDao;

	public void setMenuItemsDao(MenuItemsDao menuItemsDao) {
		this.menuItemsDao = menuItemsDao;
	}

	@Override
	public List<MenuItems> getAllItems() throws SystemException {
		return menuItemsDao.getAllItems();
	}

	@Override
	public MenuItems getItemById(int id) throws SystemException {
		Optional<MenuItems> optionalMenuItem = menuItemsDao.getItemById(id);
		if (optionalMenuItem.isEmpty()) {
			throw new SystemException("Item not found with id: " + id);
		}
		return optionalMenuItem.get();
	}

}
