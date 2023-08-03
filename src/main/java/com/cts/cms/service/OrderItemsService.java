package com.cts.cms.service;

import java.util.Optional;

import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.OrderItems;

public interface OrderItemsService {

	public Optional<OrderItems> getOrderItemById(int orderId) throws SystemException;

//	double calculateTotal(OrderItems orderItem, MenuItems items);
//	double caluclteTotal(double price, int quantity) throws SystemException;
//	double calculateTotal(OrderItems orderItem) throws SystemException;
	double calculateTotal(int quantity, double price) throws SystemException;
//	double calculateTotal(int quantity, double price, int orderId) throws SystemException;

}
