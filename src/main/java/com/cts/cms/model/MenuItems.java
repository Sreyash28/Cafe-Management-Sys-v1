package com.cts.cms.model;

public class MenuItems {
	private int id;
	private String name;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuItems(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public MenuItems() {

	}

	@Override
	public String toString() {
		return "Menu_items [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}