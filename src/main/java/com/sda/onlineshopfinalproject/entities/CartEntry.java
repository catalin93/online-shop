package com.sda.onlineshopfinalproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Cart cart;


    @ManyToOne
    @JoinColumn
    private Product product;

    private Integer quantity;

}
