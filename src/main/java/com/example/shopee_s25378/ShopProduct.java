package com.example.shopee_s25378;

public class ShopProduct {
    public ShopProduct(String name, double price) {
        this.price=price;
        this.name=name;
    }
    private double price;
    private String name;

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
