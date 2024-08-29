package com.ddd.eventnd;

//默认的余额计算器
public class SimpleBalanceCalculator implements IBalanceCalculator {
    @Override
    public double calculate(Fee fee) {
        //计算已支付记录的总和
        double totalPaid = fee.getPayments().stream()
                .mapToDouble(Payment::getAmount)
                .sum();
        //返回剩余未支付金额
        return Math.max(0, fee.getBalance() - totalPaid);
    }
}
