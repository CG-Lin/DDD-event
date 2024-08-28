package com.ddd.eventnd;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    //保存与客户相关的所有费用对象的列表。
    private List<Fee> fees;
    //表示客户是否处于“高风险”状态
    private boolean isAtRisk;

    public Customer() {
        this.fees = new ArrayList<>();
        this.isAtRisk = false;
    }

    public Fee chargeFee(double amount) {
        Fee fee = new Fee(amount);
        fees.add(fee);
        this.updateAtRiskStatus();
        return fee;
    }

    public void updateAtRiskStatus() {
        //计算客户未付清的费用
        long totalWithOutstandingBalance = fees.stream()
                .filter(Fee::hasOutstandingBalance)
                .count();
        //如果客户有超过2笔未付清的费用，就被认为是处于"风险"状态
        isAtRisk = totalWithOutstandingBalance >= 2;
    }

    // Getter方法
    public boolean isAtRisk() {
        return isAtRisk;
    }

    public List<Fee> getFees() {
        return fees;
    }
}
