package com.rest.services;

import com.rest.models.MenuItem;
import com.rest.repository.MenuItemRepository;
import java.util.List;
import java.util.Optional;

public class MenuItemService {

	private final MenuItemRepository repository;

	public MenuItemService() {
		this(new MenuItemRepository());
	}

	public MenuItemService(MenuItemRepository repository) {
		this.repository = repository;
	}

	public MenuItem createMenuItem(int id, String name, double price) {
		MenuItem menuItem = new MenuItem(id, name, price);
		repository.save(menuItem);
		return menuItem;
	}

	public List<MenuItem> getAllMenuItems() {
		return repository.findAll();
	}

	public Optional<MenuItem> getMenuItemById(int id) {
		return repository.findById(id);
	}

	public boolean deleteMenuItem(int id) {
		return repository.deleteById(id);
	}
}
