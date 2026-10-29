package com.rest.models;

public class OrderItem {

	private final String name;
	private final int quantity;
	private final double unitPrice;

	public OrderItem(String name, int quantity, double unitPrice) {
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public double getSubtotal() {
		return quantity * unitPrice;
	}

	@Override
	public String toString() {
		return name + " x " + quantity + " @ " + unitPrice + " = " + getSubtotal();
	}
}
