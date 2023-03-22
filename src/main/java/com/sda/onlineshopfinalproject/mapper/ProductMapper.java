package com.sda.onlineshopfinalproject.mapper;

import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.entities.Product;
import com.sun.jdi.IntegerValue;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {


    public Product  mapProduct(ProductDTO productDTO){
        return  Product.builder()
                .price(Integer.valueOf(productDTO.getPrice()))
                .description(productDTO.getDescription())
                .category(productDTO.getCategory())
                .name(productDTO.getName())
                .unitsInStock(Integer.valueOf(productDTO.getUnitsInStock()))
                .build();


    }
}
