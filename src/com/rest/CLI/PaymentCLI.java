package com.rest.CLI;

import com.rest.models.Payment;
import com.rest.payment.CardPayment;
import com.rest.payment.CashPayment;
import com.rest.payment.PaymentMethod;
import com.rest.services.PaymentService;
import java.util.List;
import java.util.Scanner;

public class PaymentCLI {
    private final PaymentService service;
    private final Scanner scanner;

    public PaymentCLI(){
        this(new PaymentService(), new Scanner(System.in));
    }

    public PaymentCLI(PaymentService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start(){
        boolean running = true;
        while (running) {
            System.out.println("\n--- Payment Management ---");
            System.out.println("1. Process Payment");
            System.out.println("2. View All Payments");
            System.out.println("3. View Payment by ID");
            System.out.println("4. Back to Main Menu");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> processPayment();
                case 2 -> viewAllPayments();
                case 3 -> viewPaymentById();
                case 4 -> running = false;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void processPayment() {
        double amount = readDouble("Enter amount: ");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        int methodChoice = readInt("Choose payment method: ");

        PaymentMethod method;
        if (methodChoice == 1) {
            method = new CashPayment();
        } else if (methodChoice == 2) {
            method = new CardPayment();
        } else {
            System.out.println("Invalid payment method.");
            return;
        }

        Payment payment = service.processPayment(method, amount);
        System.out.println("Payment processed: " + payment);
    }

    private void viewAllPayments() {
        List<Payment> payments = service.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
            return;
        }

        for (Payment payment : payments) {
            System.out.println(payment);
        }
    }

    private void viewPaymentById() {
        int id = readInt("Enter Payment ID: ");
        Payment payment = service.getPaymentById(id);
        if (payment == null) {
            System.out.println("Payment not found.");
        } else {
            System.out.println(payment);
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

    private double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Please enter a valid amount.");
            }
        }
    }
}