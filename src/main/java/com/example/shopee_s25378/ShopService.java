package com.example.shopee_s25378;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class ShopService {
    public ShopService(ShopStorage shopStorage) {
        this.cart=cart;
        this.shopStorage=shopStorage;
    }
    private Cart cart;
    private final ShopStorage shopStorage;

    public Satus orderItems(Cart cart){

        for (String s : cart.getProducts()){
            if (isProductInStorage(s)){
                cart.addToPrice(findProductInStorage(s).getPrice());
            }
            else throw new NoSuchElementException();

            if (cart.getPrice()<=cart.getClientSaldo()){
                cart.setClientSaldo(cart.getPrice());
                cart.setStatus(Satus.OK);
            }
            else{
                cart.setStatus(Satus.ERR);
            }
        }
        return cart.getStatus();
    }

    public boolean isProductInStorage(String product){
        boolean toReturn=false;
        for (String s : shopStorage.getProducts()){
            if(product.equals(s)){
                toReturn=true;
            }
        }
        return toReturn;
    }
    public ShopProduct findProductInStorage(String product){
        ShopProduct toReturn=null;
        for (ShopProduct s : shopStorage.getAll()){
            if(product.equals(s.getName())){
                toReturn=s;
            }
        }
        return toReturn;
    }
}
