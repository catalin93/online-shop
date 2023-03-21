package com.sda.onlineshopfinalproject.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private String price;
    private String category;
    private String unitsInStock;

}
