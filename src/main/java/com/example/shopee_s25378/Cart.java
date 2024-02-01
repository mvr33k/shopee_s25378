package com.example.shopee_s25378;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public Cart(Client client) {
        this.client=client;
    }

    private Client client;

    public double getClientSaldo(){
        return client.getSaldo();
    }

    public void setClientSaldo(double amount){
        client.setSaldo(client.getSaldo() - amount);
    }



    private double price=0;
    public void addToPrice(double amount){
        price+=amount;
    }
    public double getPrice(){
        return price;
    }

    private List<String> products=new ArrayList<>();

    public void addProduct(String product){
        products.add(product);
    }

    public List<String> getProducts(){
        return products;
    }



}
