package com.cts.cms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.cms.model.MenuItems;

public class MenuItemsMapper implements RowMapper<MenuItems> {

	@Override
	public MenuItems mapRow(ResultSet rs, int rowNum) throws SQLException {
		MenuItems menuItems = new MenuItems(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));

		return menuItems;
	}

}
