package com.sda.onlineshopfinalproject.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Nonnull
    private String name;
    private String description;
    @Nonnull
    private Integer price;
    @Nonnull
    private String category;
    @Nonnull
    private Integer unitsInStock;
}
