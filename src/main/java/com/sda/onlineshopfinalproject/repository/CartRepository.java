package com.sda.onlineshopfinalproject.repository;

import com.sda.onlineshopfinalproject.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByUserAccountEmail(String email);

}
