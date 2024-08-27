package com.ddd.eventnd;

import com.ddd.eventst.IDomainEvent;

public class FeePaidOff implements IDomainEvent {
    private Fee fee;

    public FeePaidOff(Fee fee) {
        this.fee = fee;
    }

    public Fee getFee() {
        return fee;
    }
}