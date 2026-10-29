package com.rest.payment;

public class CardPayment implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println("Paid " + amount + " using Card.");
	}

	@Override
	public String getMethodName() {
		return "Card";
	}
}
