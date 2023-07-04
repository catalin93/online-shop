package com.sda.onlineshopfinalproject.service;


import com.sda.onlineshopfinalproject.entities.Cart;
import com.sda.onlineshopfinalproject.entities.CartEntry;
import com.sda.onlineshopfinalproject.entities.Order;
import com.sda.onlineshopfinalproject.repository.CartEntryRepository;
import com.sda.onlineshopfinalproject.repository.CartRepository;
import com.sda.onlineshopfinalproject.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CartEntryRepository cartEntryRepository;
    @Autowired
    ProductService productService;

    public void placeOrder(String loggedInUserEmail){
        Cart cart = cartRepository.findByUserAccountEmail(loggedInUserEmail);
        Order order = new Order();
        order.setUserAccount(cart.getUserAccount());
//        order.setCartEntryList(cart.getCartEntryList());
  //      List<CartEntry> cartEntryList = cart.getCartEntryList();
        for (CartEntry cartEntry : cart.getCartEntryList()) {
            Long id_product = cartEntry.getProduct().getId();
            int quantityProduct = cartEntry.getQuantity();
            productService.updateById(id_product,quantityProduct);

        }

        orderRepository.save(order);
        for (CartEntry cartEntry : cart.getCartEntryList()) {
            cartEntry.setCart(null);
            cartEntry.setOrder(order);

            cartEntryRepository.save(cartEntry);
        }


    }
}
