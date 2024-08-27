package com.ddd.eventnd;

public class SimpleBalanceCalculator implements IBalanceCalculator {
    @Override
    public double calculate(Fee fee) {
        double totalPaid = fee.getPayments().stream()
                .mapToDouble(Payment::getAmount)
                .sum();
        return Math.max(0, fee.getBalance() - totalPaid);
    }
}
