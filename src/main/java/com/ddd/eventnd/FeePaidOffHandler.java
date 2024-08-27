package com.ddd.eventnd;

public class FeePaidOffHandler implements DomainEventHandler<FeePaidOff>{
    private ICustomerRepository customerRepository;

    public FeePaidOffHandler(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void handle(FeePaidOff event) {
        Fee fee = event.getFee();
        Customer customer = customerRepository.getCustomerChargedForFee(fee);
        customer.updateAtRiskStatus();
    }
}
