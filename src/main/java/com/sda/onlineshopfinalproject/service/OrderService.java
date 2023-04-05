package com.sda.onlineshopfinalproject.service;


import com.sda.onlineshopfinalproject.entities.Cart;
import com.sda.onlineshopfinalproject.entities.CartEntry;
import com.sda.onlineshopfinalproject.entities.Order;
import com.sda.onlineshopfinalproject.repository.CartEntryRepository;
import com.sda.onlineshopfinalproject.repository.CartRepository;
import com.sda.onlineshopfinalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartEntryRepository cartEntryRepository;

    public void placeOrder(String loggedInUserEmail){
        Cart cart = cartRepository.findByUserAccountEmail(loggedInUserEmail);
        Order order = new Order();
        order.setUserAccount(cart.getUserAccount());
//        order.setCartEntryList(cart.getCartEntryList());
        orderRepository.save(order);
        for (CartEntry cartEntry : cart.getCartEntryList()) {
            cartEntry.setCart(null);
            cartEntry.setOrder(order);
            cartEntryRepository.save(cartEntry);
        }


    }
}
