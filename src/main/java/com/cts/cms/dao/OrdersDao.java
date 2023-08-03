package com.cts.cms.dao;

import java.util.List;
import java.util.Optional;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.Orders;

public interface OrdersDao {

	public Optional<Orders> getOrdersById(int orderId) throws SystemException;

	public List<Orders> getAllOrders() throws SystemException;

}
