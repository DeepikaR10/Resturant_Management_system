package com.rest;

import com.rest.CLI.MenuItemCLI;
import com.rest.CLI.OrderCLI;
import com.rest.CLI.OrderItemCLI;
import com.rest.CLI.TableCLI;
import com.rest.CLI.PaymentCLI;
import com.rest.services.MenuItemService;
import com.rest.services.OrderItemService;
import com.rest.services.OrderService;
import com.rest.services.PaymentService;
import com.rest.services.TableService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TableCLI tableCLI = new TableCLI(new TableService(), scanner);
        OrderCLI orderCLI = new OrderCLI(new OrderService(), scanner);
        OrderItemCLI orderItemCLI = new OrderItemCLI(new OrderItemService(), scanner);
        MenuItemCLI menuItemCLI = new MenuItemCLI(new MenuItemService(), scanner);
        PaymentCLI paymentCLI = new PaymentCLI(new PaymentService(), scanner);

        boolean running = true;
        while (running) {
            System.out.println("\n=== RESTAURANT MANAGEMENT SYSTEM ===");
            System.out.println("1. Table Management");
            System.out.println("2. Order Management");
            System.out.println("3. Order Item Management");
            System.out.println("4. Menu Item Management");
            System.out.println("5. Payment Management");
            System.out.println("0. Exit");

            int choice = readInt(scanner, "Enter Choice: ");
            switch (choice) {
                case 1 -> tableCLI.start();
                case 2 -> orderCLI.start();
                case 3 -> orderItemCLI.start();
                case 4 -> menuItemCLI.start();
                case 5 -> paymentCLI.start();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("Thank you!");
        scanner.close();
    }

    private static int readInt(Scanner scanner, String prompt) {
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