package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.AddItemToCartRequest;
import com.lcwd.electronic.store.ElectronicStore.dtos.CartDto;

public interface CartService {

    // add items to cart
    CartDto addItemTOCart(String userId, AddItemToCartRequest request);

    // remove item from cart
    void removeItemFromCart(String userId,int cartItem);

    // clear cart
    void clearCart(String userId);
}
