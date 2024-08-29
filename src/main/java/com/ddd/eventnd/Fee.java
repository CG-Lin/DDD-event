package com.ddd.eventnd;

import java.util.ArrayList;
import java.util.List;

//系统中的一次收费或费用记录
public class Fee {
    //保存已支付记录。
    private List<Payment> payments;
    //表示当前费用的剩余未支付金额
    private double balance;

    public Fee(double amount) {
        this.payments = new ArrayList<>();
        this.balance = amount;
    }

    // 记录支付并可能触发领域事件
    public Payment recordPayment(double paymentAmount, IBalanceCalculator balanceCalculator) {
        Payment payment = new Payment(paymentAmount);
        payments.add(payment);

        //计算剩余
        balance = balanceCalculator.calculate(this);

        //如果当前未支付余额为0，触发领域事件
        if (balance == 0) {
            DomainEvents.raise(new FeePaidOff(this));
        }

        return payment;
    }

    // 检查是否有未付余额
    public boolean hasOutstandingBalance() {
        return balance > 0;
    }

    public double getBalance() {
        return balance;
    }

    public List<Payment> getPayments() {
        return payments;
    }
}