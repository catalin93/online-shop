package com.sda.onlineshopfinalproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    private UserAccount userAccount;

    @OneToMany(mappedBy = "cart")
    private List<CartEntry> cartEntryList;






}
