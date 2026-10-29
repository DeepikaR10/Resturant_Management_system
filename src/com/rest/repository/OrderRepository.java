package com.rest.repository;

import com.rest.models.Order;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepository {

	private final List<Order> orders = new ArrayList<>();

	public void save(Order order) {
		orders.add(order);
	}

	public List<Order> findAll() {
		return new ArrayList<>(orders);
	}

	public Optional<Order> findById(int id) {
		return orders.stream()
				.filter(order -> order.getId() == id)
				.findFirst();
	}

	public boolean deleteById(int id) {
		return orders.removeIf(order -> order.getId() == id);
	}
}
