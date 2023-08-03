package com.cts.cms.service;

import java.util.List;
import java.util.Optional;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.Orders;

public interface OrdersService {
	public Optional<Orders> getOrdersById(int orderId) throws SystemException;

	public List<Orders> getAllOrders() throws SystemException;

}
