
package com.rest.payment;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Cash.");
    }

    @Override
    public String getMethodName() {
        return "Cash";
    }
    
}