package com.sda.onlineshopfinalproject.mapper;

import com.sda.onlineshopfinalproject.dto.CartEntryDTO;
import com.sda.onlineshopfinalproject.entities.CartEntry;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
@Component
public class CartEntryMapper {



        public CartEntryDTO map(CartEntry cartEntry){
            return CartEntryDTO.builder()
                    .name(cartEntry.getProduct().getName())
                    .price(String.valueOf(cartEntry.getProduct().getPrice()))
                    .quantity(String.valueOf(cartEntry.getQuantity()))
                    .total(String.valueOf(cartEntry.getProduct().getPrice()*cartEntry.getQuantity()))
                    .image(Base64.encodeBase64String(cartEntry.getProduct().getImg()))
                    .build();
        }

}
