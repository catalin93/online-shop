package com.sda.onlineshopfinalproject.dto;


import lombok.Builder;
import lombok.Data;


import java.util.List;
@Data
@Builder
public class CheckoutDTO {

    private String subtotal;
    private String shippingFee;
    private String total;

    private List<CartEntryDTO> cartEntryDTOList;

}
