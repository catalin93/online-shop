package com.sda.onlineshopfinalproject.dto;

import com.sda.onlineshopfinalproject.enums.UserRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserAccountDTO {
    private String fullName;
    private String address;
    private String email;
    private  String password;

    private String userRole;

}
