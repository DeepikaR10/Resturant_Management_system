package com.rest.repository;

import com.rest.models.OrderItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderItemRepository {

	private final List<OrderItem> items = new ArrayList<>();

	public void save(OrderItem item) {
		items.add(item);
	}

	public List<OrderItem> findAll() {
		return new ArrayList<>(items);
	}

	public List<OrderItem> findByName(String name) {
		return items.stream()
				.filter(item -> Objects.equals(item.getName(), name))
				.toList();
	}

	public boolean deleteByName(String name) {
		return items.removeIf(item -> Objects.equals(item.getName(), name));
	}
}
