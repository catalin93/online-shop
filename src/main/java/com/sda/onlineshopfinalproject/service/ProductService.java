package com.sda.onlineshopfinalproject.service;

import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.entities.Product;
import com.sda.onlineshopfinalproject.mapper.ProductMapper;
import com.sda.onlineshopfinalproject.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    public void add(ProductDTO productDTO, MultipartFile multipartFile){
        Product product = productMapper.mapProduct(productDTO,multipartFile);
        productRepository.save(product);
    }

    public void updateById(Long id, int quantity ){
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isEmpty()){
            return;
        }else{
            Product product = productOptional.get();
            product.setUnitsInStock(product.getUnitsInStock()-quantity);
            productRepository.save(product);
        }
       //TODO: DE OPTIMIZAT ACEASTA FUNCTIE, SA PUNEM QUANTITY INTRUN IF
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

    public Optional<ProductDTO> getProdactDTOById(String id){
        Optional<Product> optionalProduct = productRepository.findById(Long.valueOf(id));
        if(optionalProduct.isEmpty()){
            return Optional.empty();
        }
        ProductDTO productDTO = productMapper.mapProductDTO(optionalProduct.get());
        return Optional.of(productDTO);
    }

}
