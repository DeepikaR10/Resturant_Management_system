package com.rest.services;

import com.rest.models.OrderItem;
import com.rest.repository.OrderItemRepository;
import java.util.List;

public class OrderItemService {

	private final OrderItemRepository repository;

	public OrderItemService() {
		this(new OrderItemRepository());
	}

	public OrderItemService(OrderItemRepository repository) {
		this.repository = repository;
	}

	public OrderItem createItem(String name, int quantity, double unitPrice) {
		OrderItem item = new OrderItem(name, quantity, unitPrice);
		repository.save(item);
		return item;
	}

	public List<OrderItem> getAllItems() {
		return repository.findAll();
	}

	public List<OrderItem> getItemsByName(String name) {
		return repository.findByName(name);
	}

	public boolean deleteItemsByName(String name) {
		return repository.deleteByName(name);
	}
}
