package com.example.shopee_s25378;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ShopServiceTest {

    private ShopService shopService;
    private ShopStorage shopStorage;

    @BeforeEach
    void setUp(){
        shopStorage=new ShopStorage();
        shopService=new ShopService(shopStorage);
    }

    @AfterEach
    void tearDown(){
        shopStorage.purgeList();
    }

    @Test
    void shouldFindProduct(){
        String piwo="piwo";
        assertThat(shopService.isProductInStorage(piwo)).isTrue();
    }
    @Test
    void shouldntFindProduct(){
        String toNiePiwo="toniepiwo";
        assertThat(shopService.isProductInStorage(toNiePiwo)).isFalse();
    }

    @Test
    void shouldBeOrdered(){
        //GIVEN
        Client client=new Client(2000.00);
        Cart cart=new Cart(client);
        //WHEN
        cart.addProduct("piwo");
        cart.addProduct("piwo");
        cart.addProduct("mleko");
        //THEN
        shopService.orderItems(cart);

        assertThat(cart.getStatus().equals(Satus.OK));
    }

}
