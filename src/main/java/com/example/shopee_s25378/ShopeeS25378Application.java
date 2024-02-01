package com.example.shopee_s25378;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopeeS25378Application {

    private final ShopStorage shopStorage;
    private final ShopService shopService;

    public ShopeeS25378Application(ShopService shopService, ShopStorage shopStroage){
        this.shopStorage=shopStroage;
        this.shopService=shopService;

//        execProcess();

    }
    public static void main(String[] args) {
        SpringApplication.run(ShopeeS25378Application.class, args);
    }

    public void execProcess(){}

}
