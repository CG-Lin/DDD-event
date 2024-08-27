package com.ddd.eventnd;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private List<Fee> fees;
    private boolean isAtRisk;

    public Customer() {
        this.fees = new ArrayList<>();
        this.isAtRisk = false;
    }

    public Fee chargeFee(double amount) {
        Fee fee = new Fee(amount);
        fees.add(fee);
        return fee;
    }

    public void updateAtRiskStatus() {
        long totalWithOutstandingBalance = fees.stream()
                .filter(Fee::hasOutstandingBalance)
                .count();
        //如果客户有超过3笔未付清的费用，就被认为是处于"风险"状态
        isAtRisk = totalWithOutstandingBalance > 3;
    }

    // Getter方法
    public boolean isAtRisk() {
        return isAtRisk;
    }

    public List<Fee> getFees() {
        return fees;
    }
}
