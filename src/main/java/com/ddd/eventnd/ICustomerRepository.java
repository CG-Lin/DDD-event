package com.ddd.eventnd;

public interface ICustomerRepository {
    Customer getCustomerChargedForFee(Fee fee);
}