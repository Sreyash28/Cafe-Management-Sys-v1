package com.cts.cms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cts.cms.model.Orders;

public class OrdersMapper implements RowMapper<Orders> {

	@Override
	public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {

		Orders orders = new Orders(rs.getInt("order_id"), rs.getInt("customer_id"),
				rs.getTimestamp("date_time").toLocalDateTime(), rs.getString("order_status"));
		return orders;
	}

}
