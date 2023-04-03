package com.sda.onlineshopfinalproject.service;

import com.sda.onlineshopfinalproject.dto.ProductQuantityDTO;
import com.sda.onlineshopfinalproject.entities.Cart;
import com.sda.onlineshopfinalproject.entities.CartEntry;
import com.sda.onlineshopfinalproject.entities.Product;
import com.sda.onlineshopfinalproject.repository.CartEntryRepository;
import com.sda.onlineshopfinalproject.repository.CartRepository;
import com.sda.onlineshopfinalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartEntryRepository cartEntryRepository;

    public void addToCart(String productId, ProductQuantityDTO productQuantityDTO, String loggedInUserEmail){
        CartEntry cartEntry = new CartEntry();
        Cart cart = cartRepository.findByUserAccountEmail(loggedInUserEmail);
        cartEntry.setCart(cart);
        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(productId));
        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Product id is not valid");
        }
        cartEntry.setProduct(optionalProduct.get());
        cartEntry.setQuantity(Integer.valueOf(productQuantityDTO.getQuantity()));
        cartEntryRepository.save(cartEntry);
    }
}
