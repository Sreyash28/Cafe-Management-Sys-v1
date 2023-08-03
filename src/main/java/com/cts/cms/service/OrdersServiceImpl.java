package com.cts.cms.service;

import java.util.List;
import java.util.Optional;

import com.cts.cms.dao.OrdersDao;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.Orders;

public class OrdersServiceImpl implements OrdersService {

	private OrdersDao ordersDao;

	public void setOrdersDao(OrdersDao ordersDao) {
		this.ordersDao = ordersDao;
	}

	@Override
	public Optional<Orders> getOrdersById(int orderId) throws SystemException {
		Optional<Orders> optionalOrders = ordersDao.getOrdersById(orderId);
		if (optionalOrders.isEmpty()) {
			throw new SystemException("Product not Exists with id: " + orderId);
		}
		return Optional.of(optionalOrders.get());
	}


	@Override
	public List<Orders> getAllOrders() throws SystemException {
		return ordersDao.getAllOrders();
	}

}
