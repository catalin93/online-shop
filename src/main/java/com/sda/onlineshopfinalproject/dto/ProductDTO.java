package com.sda.onlineshopfinalproject.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private String price;
    private String category;
    private String unitsInStock;

    @ToString.Exclude
    private String img;

}
