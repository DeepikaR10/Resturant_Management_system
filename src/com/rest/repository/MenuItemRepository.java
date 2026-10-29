package com.rest.repository;

import com.rest.models.MenuItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MenuItemRepository {

	private final List<MenuItem> menuItems = new ArrayList<>();

	public void save(MenuItem menuItem) {
		menuItems.add(menuItem);
	}

	public List<MenuItem> findAll() {
		return new ArrayList<>(menuItems);
	}

	public Optional<MenuItem> findById(int id) {
		return menuItems.stream()
				.filter(menuItem -> menuItem.getId() == id)
				.findFirst();
	}

	public boolean deleteById(int id) {
		return menuItems.removeIf(menuItem -> menuItem.getId() == id);
	}
}
