package com.cts.cms.dao;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.MenuItems;


public class MenuItemsSpringJdbcImpl implements MenuItemsDao {
	private final String Get_All_Items = "select * from menu_items";
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<MenuItems> getAllItems() throws SystemException {

		return jdbcTemplate.query(Get_All_Items,
				(rs, no) -> new MenuItems(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
	}

	@Override
	public Optional<MenuItems> getItemById(int id) throws SystemException {
		String sql = "SELECT * FROM menu_items WHERE id = ?";
		MenuItems items = null;
		try {
			items = jdbcTemplate.queryForObject(sql, new MenuItemsMapper(), id);
		} catch (Exception e) {
			throw new SystemException("Id not found with id: " + id);
		}

		return Optional.of(items);

	}

}
