package com.rest.CLI;

import com.rest.models.OrderItem;
import com.rest.services.OrderItemService;
import java.util.List;
import java.util.Scanner;

public class OrderItemCLI {

	private final OrderItemService service;
	private final Scanner scanner;

	public OrderItemCLI(OrderItemService service) {
		this(service, new Scanner(System.in));
	}

	public OrderItemCLI(OrderItemService service, Scanner scanner) {
		this.service = service;
		this.scanner = scanner;
	}

	public void start() {
		boolean running = true;

		while (running) {
			System.out.println("\n=== RESTAURANT ORDER ITEM MANAGEMENT ===");
			System.out.println("1. Add Item");
			System.out.println("2. View All Items");
			System.out.println("3. Search Items by Name");
			System.out.println("4. Delete Items by Name");
			System.out.println("0. Back to Main Menu");

			int choice = readInt("Enter Choice: ");
			switch (choice) {
				case 1 -> addItem();
				case 2 -> viewAllItems();
				case 3 -> searchItems();
				case 4 -> deleteItems();
				case 0 -> running = false;
				default -> System.out.println("Invalid choice. Please try again.");
			}
		}

		System.out.println("Thank you!");
	}

	private void addItem() {
		System.out.print("Enter item name: ");
		String name = scanner.nextLine();
		int quantity = readInt("Enter quantity: ");
		double unitPrice = readDouble("Enter unit price: ");
		OrderItem item = service.createItem(name, quantity, unitPrice);
		System.out.println("Item added: " + item);
	}

	private void viewAllItems() {
		List<OrderItem> items = service.getAllItems();
		System.out.println("\n=== ALL ORDER ITEMS ===");
		if (items.isEmpty()) {
			System.out.println("No items found.");
			return;
		}

		for (OrderItem item : items) {
			System.out.println(item);
		}
	}

	private void searchItems() {
		System.out.print("Enter item name: ");
		String name = scanner.nextLine();
		List<OrderItem> items = service.getItemsByName(name);
		if (items.isEmpty()) {
			System.out.println("No matching items found.");
			return;
		}

		for (OrderItem item : items) {
			System.out.println(item);
		}
	}

	private void deleteItems() {
		System.out.print("Enter item name: ");
		String name = scanner.nextLine();
		if (service.deleteItemsByName(name)) {
			System.out.println("Matching items deleted.");
		} else {
			System.out.println("No matching items found.");
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
