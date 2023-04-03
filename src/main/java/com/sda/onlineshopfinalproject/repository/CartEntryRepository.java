package com.sda.onlineshopfinalproject.repository;

import com.sda.onlineshopfinalproject.entities.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {


}
