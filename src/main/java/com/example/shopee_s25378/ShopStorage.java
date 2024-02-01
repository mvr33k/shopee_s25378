package com.example.shopee_s25378;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ShopStorage {

    ShopStorage(){
        products.add(new ShopProduct("piwo",2.50));
        products.add(new ShopProduct("mleko",3.00));
    }
    private List<ShopProduct> products = new ArrayList<>();

    public void addProduct(ShopProduct product) {
        products.add(product);
    }

//    public Optional<Client> findClientById(int clientId) {
//        return getAll().stream()
//                .filter(client -> client.getId().equals(clientId))
//                .findFirst();
//    }

    public List<ShopProduct> getAll() {
        return products;
    }

    public List<String> getProducts(){
        List<String> productsNames = new ArrayList<>();
        for (ShopProduct i : products){
            productsNames.add(i.getName());
        }
        return productsNames;
    }




    public void purgeList() {
        products.clear();
    }
}


