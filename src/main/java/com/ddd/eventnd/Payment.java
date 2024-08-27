package com.ddd.eventnd;

public class Payment {
    private double amount;
    private Fee fee;

    public Payment(double amount, Fee fee) {
        this.amount = amount;
        this.fee = fee;
    }

    // Getter方法
    public double getAmount() {
        return amount;
    }

    public Fee getFee() {
        return fee;
    }
}
