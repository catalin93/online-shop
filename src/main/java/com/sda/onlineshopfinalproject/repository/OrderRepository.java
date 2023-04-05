package com.sda.onlineshopfinalproject.repository;

import com.sda.onlineshopfinalproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
