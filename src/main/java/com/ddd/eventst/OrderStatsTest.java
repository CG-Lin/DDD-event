package com.ddd.eventst;

import java.util.Arrays;

public class OrderStatsTest {
    public static void main(String[] args) {
        // 初始化消费者，注册事件处理程序
        new OrderStats();

        // 创建产品线
        ProductLine product1 = new ProductLine("Product A", 2, 50.0);
        ProductLine product2 = new ProductLine("Product B", 3,75.5 );

        // 创建订单并触发 OrderSubmitted 事件
        Order order = new Order(Arrays.asList(product1, product2));
    }
}
