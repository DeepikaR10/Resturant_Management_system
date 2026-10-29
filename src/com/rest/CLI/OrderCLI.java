package com.rest.CLI;

import com.rest.models.Order;
import com.rest.services.OrderService;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrderCLI {

	private final OrderService service;
	private final Scanner scanner;

	public OrderCLI(OrderService service) {
		this(service, new Scanner(System.in));
	}

	public OrderCLI(OrderService service, Scanner scanner) {
		this.service = service;
		this.scanner = scanner;
	}

	public void start() {
		boolean running = true;

		while (running) {
			System.out.println("\n=== RESTAURANT ORDER MANAGEMENT ===");
			System.out.println("1. Create Order");
			System.out.println("2. View All Orders");
			System.out.println("3. Find Order by ID");
			System.out.println("4. Delete Order");
			System.out.println("0. Back to Main Menu");

			int choice = readInt("Enter Choice: ");
			switch (choice) {
				case 1 -> createOrder();
				case 2 -> viewAllOrders();
				case 3 -> findOrder();
				case 4 -> deleteOrder();
				case 0 -> running = false;
				default -> System.out.println("Invalid choice. Please try again.");
			}
		}

		System.out.println("Thank you!");
	}

	private void createOrder() {
		int id = readInt("Enter Order ID: ");
		int tableId = readInt("Enter Table ID: ");
		Order order = service.createOrder(id, tableId);
		System.out.println("Order created: " + order);
	}

	private void viewAllOrders() {
		List<Order> orders = service.getAllOrders();
		System.out.println("\n=== ALL ORDERS ===");
		if (orders.isEmpty()) {
			System.out.println("No orders found.");
			return;
		}

		for (Order order : orders) {
			System.out.println(order);
		}
	}

	private void findOrder() {
		int id = readInt("Enter Order ID: ");
		Optional<Order> order = service.getOrderById(id);
		if (order.isPresent()) {
			System.out.println(order.get());
		} else {
			System.out.println("Order not found.");
		}
	}

	private void deleteOrder() {
		int id = readInt("Enter Order ID: ");
		if (service.deleteOrder(id)) {
			System.out.println("Order deleted.");
		} else {
			System.out.println("Order not found.");
		}
	}

	private int readInt(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("Please enter a valid number.");
			}
		}
	}
}
