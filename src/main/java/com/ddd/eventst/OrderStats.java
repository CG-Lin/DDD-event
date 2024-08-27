package com.ddd.eventst;

/**
 * 收集订单统计信息
 */
public class OrderStats {

    // 注册订单提交事件的处理程序
    static {
        DomainEvents.register(OrderSubmitted.class, OrderStats::processSubmittedOrder);
    }

    /**
     * 提交订单
     */
    static void processSubmittedOrder(OrderSubmitted ev) {
        double amount = ev.getOrder().getAmount();
        int numberOfItems = ev.getOrder().getNumberOfItems();

        // 将amount和numberOfItems保存到数据库中
        System.out.println("Persisting amount: " + amount + ", numberOfItems: " + numberOfItems);
    }
}

