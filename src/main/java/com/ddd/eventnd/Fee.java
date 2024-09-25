package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuk
 * @description:
 * @menu
 * @date 2024/9/23 23:00
 */
public class Fee implements IEntity{
    private List<Payment> payments;
    private List<IDomainEvent> events = new ArrayList<>();
    private double balance;

    public Fee(double amount) {
        this.payments = new ArrayList<>();
        this.balance = amount;
    }

    // 检查是否有未付余额
    public boolean hasOutstandingBalance() {
        return balance > 0;
    }

    public Payment recordPayment(double paymentAmount, IBalanceCalculator balanceCalculator) {
        Payment payment = new Payment(paymentAmount);
        payments.add(payment);

        //计算剩余
        balance = balanceCalculator.calculate(this);

        //如果当前未支付余额为0，触发领域事件
        if (balance == 0) {
            events.add(new FeePaidOff(this));
        }

        return payment;
    }

    @Override
    public List<IDomainEvent> getEvents() {
        return events;
    }

    @Override
    public void clearEvents() {
        events.clear();
    }
}
