package com.sda.onlineshopfinalproject.service;

import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.entities.Product;
import com.sda.onlineshopfinalproject.mapper.ProductMapper;
import com.sda.onlineshopfinalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    public void add(ProductDTO productDTO){
        Product product = productMapper.mapProduct(productDTO);
        productRepository.save(product);
    }


}
