package com.ddd.eventnd;

//表示客户支付的一次费用，记录了与支付相关的具体信息。
public class Payment {
    //表示此次支付的金额
    private double amount;
    //表示与此次支付关联的Fee对象。
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
