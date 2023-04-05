package com.sda.onlineshopfinalproject.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
//"Order" este un cuvant rezervat in sql
@Entity
@Data
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private UserAccount userAccount;

    @OneToMany(mappedBy = "order")
    private List<CartEntry> cartEntryList;
}
