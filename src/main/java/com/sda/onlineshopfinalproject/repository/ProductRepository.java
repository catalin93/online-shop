package com.sda.onlineshopfinalproject.repository;

import com.sda.onlineshopfinalproject.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
