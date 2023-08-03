package com.cts.cms.dao;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.Orders;

public class OrdersDaoSpringJdbcImpl implements OrdersDao {
	private final String Get_Orders_By_Id = "select * from orders where order_id=?";
	private final String Get_All_Orders = "select * from orders";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Orders> getAllOrders() throws SystemException {

		return jdbcTemplate.query(Get_All_Orders,
				(rs, no) -> new Orders(rs.getInt("order_id"), rs.getInt("customer_id"),
						rs.getTimestamp("date_time").toLocalDateTime(), rs.getString("order_status")));
	}

	@Override
	public Optional<Orders> getOrdersById(int orderId) throws SystemException {
		return Optional.of(jdbcTemplate.queryForObject(Get_Orders_By_Id, new OrdersMapper(), orderId));
	}

}
