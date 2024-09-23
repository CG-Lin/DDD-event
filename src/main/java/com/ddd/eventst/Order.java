package com.ddd.eventst;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author wuk
 * @description:
 * @menu
 * @date 2024/8/25 23:12
 */
public class Order {

    private List<OrderLine> lines;

    public Customer customer;

    public List<OrderLine> getLines() {
        return lines;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Order(Iterable<ProductLine> productLines) {
        //将产品项集合转为订单项集合
        this.lines = StreamSupport.stream(productLines.spliterator(), false)
                .map(x -> new OrderLine(x.getProduct(), x.getPrice(), x.getQuantity()))
                .collect(Collectors.toList());
        // 触发提交订单事件
        DomainEvents.raise(new OrderSubmitted(this));
    }

    // 计算订单的总金额
    public double getAmount() {
        return lines.stream()
                .mapToDouble(line -> line.getQuantity() * line.getPrice())
                .sum();
    }

    // 计算订单中商品的总数量
    public int getNumberOfItems() {
        return lines.stream()
                .mapToInt(OrderLine::getQuantity)
                .sum();
    }
}
