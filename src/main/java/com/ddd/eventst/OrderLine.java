package com.ddd.eventst;

import lombok.Data;

/**
 * @author wuk
 * @description:
 * @menu
 * @date 2024/8/25 23:50
 */
@Data
public class OrderLine {

    private String product;

    private double price;

    private int quantity;

    public OrderLine(String product, Double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
}
