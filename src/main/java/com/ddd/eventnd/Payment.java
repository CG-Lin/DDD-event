package com.ddd.eventnd;

//表示客户每次支付的费用，记录了与支付相关的具体信息。
public class Payment {
    //表示此次支付的金额
    private double amount;

    public Payment(double amount) {
        this.amount = amount;
    }
    // Getter方法
    public double getAmount() {
        return amount;
    }
}
