package com.rest.services;

import com.rest.models.Order;
import com.rest.repository.OrderRepository;
import java.util.List;
import java.util.Optional;

public class OrderService {

	private final OrderRepository repository;

	public OrderService() {
		this(new OrderRepository());
	}

	public OrderService(OrderRepository repository) {
		this.repository = repository;
	}

	public Order createOrder(int id, int tableId) {
		Order order = new Order(id, tableId);
		repository.save(order);
		return order;
	}

	public List<Order> getAllOrders() {
		return repository.findAll();
	}

	public Optional<Order> getOrderById(int id) {
		return repository.findById(id);
	}

	public boolean deleteOrder(int id) {
		return repository.deleteById(id);
	}
}
