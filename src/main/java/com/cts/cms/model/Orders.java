package com.cts.cms.model;

import java.time.LocalDateTime;

public class Orders {

	private int orderId;
	private int customerId;
	private LocalDateTime dateTime;
	private String orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Orders(int orderId, int customerId, LocalDateTime dateTime, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.dateTime = dateTime;
		this.orderStatus = orderStatus;
	}

	public Orders() {

	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customerId + ", dateTime=" + dateTime + ", orderStatus="
				+ orderStatus + "]";
	}
}
