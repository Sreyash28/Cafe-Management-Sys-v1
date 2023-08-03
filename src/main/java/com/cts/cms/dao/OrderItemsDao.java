package com.cts.cms.dao;

import java.util.Optional;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.OrderItems;



public interface OrderItemsDao {

	public Optional<OrderItems> getOrderItemById(int orderId) throws SystemException;

}
