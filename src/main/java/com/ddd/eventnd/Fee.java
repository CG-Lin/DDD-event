package com.ddd.eventnd;

import java.util.ArrayList;
import java.util.List;

public class Fee {
    private List<Payment> payments;
    private double balance;

    public Fee(double amount) {
        this.payments = new ArrayList<>();
        this.balance = amount;
    }

    // 记录支付并可能触发领域事件
    public Payment recordPayment(double paymentAmount, IBalanceCalculator balanceCalculator) {
        Payment payment = new Payment(paymentAmount, this);
        payments.add(payment);

        balance = balanceCalculator.calculate(this);

        if (balance == 0) {
            DomainEvents.raise(new FeePaidOff(this));
        }

        return payment;
    }

    // 检查是否有未付余额
    public boolean hasOutstandingBalance() {
        return balance > 0;
    }

    // Getter方法
    public double getBalance() {
        return balance;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}