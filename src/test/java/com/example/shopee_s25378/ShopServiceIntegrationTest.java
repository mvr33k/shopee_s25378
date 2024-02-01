package com.example.shopee_s25378;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest
public class ShopServiceIntegrationTest {
    @MockBean
    private ShopStorage shopStorage;
    @Autowired
    private ShopService shopService;


    @Test
    void shouldFindByName(){
        ShopProduct product1=new ShopProduct("piwo",2.50);
        ShopProduct product2=new ShopProduct("mleko", 2.00);
        List<ShopProduct> productList=new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(shopStorage.getAll()).thenReturn(productList);

        assertThat(shopService.isProductInStorage("piwo")).isTrue();
    }

    void shouldNotOrder(){
        Client client=new Client(0);
        ShopProduct product1=new ShopProduct("piwo",2.50);
        List<ShopProduct> productList=new ArrayList<>();
        productList.add(product1);
        Cart cart=new Cart(client);
        cart.addProduct("piwo");

        when(shopStorage.getAll()).thenReturn(productList);



        shopService.orderItems(cart);

        assertThat(cart.getStatus().equals(Satus.OK));
    }


}
