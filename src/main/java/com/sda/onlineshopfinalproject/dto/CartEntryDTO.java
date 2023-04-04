package com.sda.onlineshopfinalproject.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CartEntryDTO {
    private String image;
    private String name;
    private String price;
    private String quantity;
    private String total;


}
