package com.sda.onlineshopfinalproject.entities;

import com.sda.onlineshopfinalproject.enums.ProductCategory;
import com.sda.onlineshopfinalproject.enums.UserRole;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
//    @Nonnull
//    private String category;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    @Nonnull
    private Integer unitsInStock;

    // imaginile in baza de date sunt salvate ca BLOB
    @Lob
    @Column(columnDefinition = "BLOB")
    private byte[] img;

    @OneToMany(mappedBy = "product")
    private List<CartEntry> cartEntryList;


}
