package com.cts.cms.model;

public class OrderItems {

	private int orderId;
	private int itemId;
	private int quantity;
	private double subTotal;

	public OrderItems() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItems(int orderId, int itemId, int quantity, double subTotal) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + ", subTotal="
				+ subTotal + "]";
	}

}
