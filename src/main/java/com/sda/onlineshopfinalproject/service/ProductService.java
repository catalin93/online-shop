package com.sda.onlineshopfinalproject.service;

import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.entities.Product;
import com.sda.onlineshopfinalproject.mapper.ProductMapper;
import com.sda.onlineshopfinalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public List<ProductDTO> getAllProductDTO() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        List<Product> productList = productRepository.findAll();
        for (Product product: productList) {
           ProductDTO productDTO = productMapper.mapProductDTO(product);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }
}
