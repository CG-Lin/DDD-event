package com.ddd.eventnd;

//模拟数据库
public class CustomerRepository implements  ICustomerRepository{
    private Customer customer;

    @Override
    public Customer getCustomerChargedForFee(Fee fee) {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
