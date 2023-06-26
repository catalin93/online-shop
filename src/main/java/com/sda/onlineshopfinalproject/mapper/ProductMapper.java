package com.sda.onlineshopfinalproject.mapper;

import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.entities.Product;
import com.sda.onlineshopfinalproject.enums.ProductCategory;
import com.sun.jdi.IntegerValue;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class ProductMapper {


    public Product  mapProduct(ProductDTO productDTO, MultipartFile multipartFile){
        return  Product.builder()
                .price(Integer.valueOf(productDTO.getPrice()))
                .description(productDTO.getDescription())
                .category(ProductCategory.valueOf(productDTO.getCategory()))
                .name(productDTO.getName())
                .unitsInStock(Integer.valueOf(productDTO.getUnitsInStock()))
                .img(convertToByte(multipartFile))
                .build();
    }

    public ProductDTO mapProductDTO(Product product) {
        return ProductDTO.builder()
                .price(String.valueOf(product.getPrice()))
                .description(product.getDescription())
                .category(String.valueOf(product.getCategory()))
                .name(product.getName())
                .unitsInStock(String.valueOf(product.getUnitsInStock()))
                .id(String.valueOf(product.getId()))
                .img(Base64.encodeBase64String(product.getImg()))
                .build();
    }
    // TODO: la mapProductDTO ar putea fi o problema la transformarea categoriei

    private byte[] convertToByte(MultipartFile multipartFile){
        try {
            return multipartFile.getBytes();
        } catch (IOException e) {
            return new byte[0];
        }
    }
}
