package com.cts.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.cts.cms.dao.MenuItemsDao;
import com.cts.cms.dao.OrderItemsDao;
import com.cts.cms.exceptions.SystemException;
import com.cts.cms.model.MenuItems;
import com.cts.cms.model.OrderItems;

public class OrderItemsServiceImpl implements OrderItemsService {

	@Autowired
	private MenuItemsDao menuItemsDao;

	public MenuItemsDao getMenuItemsDao() {
		return menuItemsDao;
	}

//
	private OrderItemsDao orderItemsDao;

	public void setOrderItemsDao(OrderItemsDao orderItemsDao) {
		this.orderItemsDao = orderItemsDao;
	}

	public OrderItemsServiceImpl() {

	}

	@Override
	public Optional<OrderItems> getOrderItemById(int orderId) throws SystemException {
		Optional<OrderItems> optionalOrderItem = orderItemsDao.getOrderItemById(orderId);
		if (optionalOrderItem.isEmpty()) {
			throw new SystemException("Product not Exists with id: " + orderId);
		}
		return Optional.of(optionalOrderItem.get());
	}

	@Override
	public double calculateTotal(int quantity, double price) throws SystemException {
		double total = 0;
		try {

			List<MenuItems> items = menuItemsDao.getAllItems();

			for (MenuItems item : items) {
				if (item.getPrice() == price) {
					total = quantity * price;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new SystemException("Invalid Result, please try again.");
		}
		return total;
	}
}
