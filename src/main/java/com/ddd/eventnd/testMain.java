package com.ddd.eventnd;

public class testMain {
    public static void main(String[] args) {
        // 创建一个模拟的CustomerRepository
        CustomerRepository customerRepository = new CustomerRepository();

        // 注册FeePaidOff事件处理器
        FeePaidOffHandler handler = new FeePaidOffHandler(customerRepository);
        DomainEvents.register(FeePaidOff.class, handler);

        // 创建客户并收费
        Customer customer = new Customer();
        customerRepository.setCustomer(customer);
        Fee fee1 = customer.chargeFee(100);
        Fee fee2 = customer.chargeFee(200);
        Fee fee3 = customer.chargeFee(300);
        Fee fee4 = customer.chargeFee(400);
        System.out.println("Initial at-risk status: " + customer.isAtRisk());

        // 支付费用
        IBalanceCalculator balanceCalculator = new SimpleBalanceCalculator();
        fee1.recordPayment(100, balanceCalculator);
        fee2.recordPayment(200, balanceCalculator);
        fee3.recordPayment(300, balanceCalculator);
        System.out.println("At-risk status after paying 3 fees: " + customer.isAtRisk());

        // 支付最后一笔费用
        fee4.recordPayment(400, balanceCalculator);

        System.out.println("Final at-risk status: " + customer.isAtRisk());
    }
}
