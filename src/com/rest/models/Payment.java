

package com.rest.models;

public class Payment {

    private final int paymentId;
    private final double amount;
    private final String method;
    private String status;

    public Payment(int paymentId, double amount, String method) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.method = method;
        this.status = "PENDING";
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Payment ID: " + paymentId
                + ", Amount: Rs." + amount
                + ", Method: " + method
                + ", Status: " + status;
    }
}