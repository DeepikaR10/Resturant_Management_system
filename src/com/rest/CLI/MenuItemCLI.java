package com.rest.CLI;

import com.rest.models.MenuItem;
import com.rest.services.MenuItemService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class MenuItemCLI {

	private final MenuItemService service;
	private final Scanner scanner;

	public MenuItemCLI(MenuItemService service) {
		this(service, new Scanner(System.in));
	}

	public MenuItemCLI(MenuItemService service, Scanner scanner) {
		this.service = service;
		this.scanner = scanner;
	}

	public void start() {
		boolean running = true;

		while (running) {
			System.out.println("\n=== RESTAURANT MENU ITEM MANAGEMENT ===");
			System.out.println("1. Add Menu Item");
			System.out.println("2. View All Menu Items");
			System.out.println("3. Find Menu Item by ID");
			System.out.println("4. Delete Menu Item");
			System.out.println("0. Back to Main Menu");

			int choice = readInt("Enter Choice: ");
			switch (choice) {
				case 1 -> addMenuItem();
				case 2 -> viewAllMenuItems();
				case 3 -> findMenuItem();
				case 4 -> deleteMenuItem();
				case 0 -> running = false;
				default -> System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private void addMenuItem() {
		int id = readInt("Enter Menu Item ID: ");
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		double price = readDouble("Enter price: ");

		MenuItem menuItem = service.createMenuItem(id, name, price);
		System.out.println("Menu item added: " + menuItem);
	}

	private void viewAllMenuItems() {
		List<MenuItem> menuItems = service.getAllMenuItems();
		System.out.println("\n=== ALL MENU ITEMS ===");
		if (menuItems.isEmpty()) {
			System.out.println("No menu items found.");
			return;
		}

		for (MenuItem menuItem : menuItems) {
			System.out.println(menuItem);
		}
	}

	private void findMenuItem() {
		int id = readInt("Enter Menu Item ID: ");
		Optional<MenuItem> menuItem = service.getMenuItemById(id);
		if (menuItem.isPresent()) {
			System.out.println(menuItem.get());
		} else {
			System.out.println("Menu item not found.");
		}
	}

	private void deleteMenuItem() {
		int id = readInt("Enter Menu Item ID: ");
		if (service.deleteMenuItem(id)) {
			System.out.println("Menu item deleted.");
		} else {
			System.out.println("Menu item not found.");
		}
	}

	private int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("Please enter a valid whole number.");
			}
		}
	}

	private double readDouble(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("Please enter a valid price.");
			}
		}
	}
}
