package com.ddd.eventst;

/**
 * ；领域事件:封装了订单提交事件的信息
 */
public class OrderSubmitted implements IDomainEvent{
    public Order Order;

    public Order getOrder() {
        return Order;
    }

    public OrderSubmitted(Order order) {
        Order = order;
    }

}
