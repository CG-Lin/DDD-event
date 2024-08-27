package com.ddd.eventst;

import lombok.Data;

/**
 * @author wuk
 * @description:
 * @menu
 * @date 2024/8/25 23:50
 */
@Data
public class ProductLine {

    private String product;

    private double price;

    private int quantity;

    public ProductLine(String product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }
}
