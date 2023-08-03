package com.cts.cms.dao;

import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.OrderItems;

public class OrderItemsDaoSpringJdbcImpl implements OrderItemsDao {

	private static final String Find_Order_By_Id = "select * from order_items where order_id=?";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Optional<OrderItems> getOrderItemById(int orderId) throws SystemException {
		OrderItems orderItems = null;

		try {
			orderItems = jdbcTemplate.queryForObject(Find_Order_By_Id, new OrderItemsMapper(), orderId);
		} catch (Exception e) {
			throw new SystemException("Id not found with id: " + orderId);
		}

		return Optional.of(orderItems);
	}

}
