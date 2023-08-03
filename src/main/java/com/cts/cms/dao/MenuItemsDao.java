package com.cts.cms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.MenuItems;

@Component
public interface MenuItemsDao {
	
	public List<MenuItems> getAllItems() throws SystemException;

	public Optional<MenuItems> getItemById(int id) throws SystemException;
}
