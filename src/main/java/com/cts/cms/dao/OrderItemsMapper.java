package com.cts.cms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.cms.model.OrderItems;

public class OrderItemsMapper implements RowMapper<OrderItems> {

	@Override
	public OrderItems mapRow(ResultSet rs, int rowNum) throws SQLException {
		OrderItems orderItems = new OrderItems(rs.getInt("order_id"), rs.getInt("item_id"), rs.getInt("quantity"),
				rs.getDouble("subtotal"));

		return orderItems;
	}

}
