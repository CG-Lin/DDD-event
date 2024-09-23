package com.ddd.eventst;

public class OrderNotification {
    static {
        // 注册订单提交事件的处理程序
        DomainEvents.register(OrderSubmitted.class, OrderNotification::processSubmittedOrder);
    }

    private static void processSubmittedOrder(OrderSubmitted event) {
        // 使用订单信息发送通知邮件 (此处仅输出模拟)
        System.out.println("Sending notification email to " + event.getOrder().getCustomer().getEmail());
    }
}
