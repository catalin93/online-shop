package com.sda.onlineshopfinalproject.mapper;

import com.sda.onlineshopfinalproject.dto.UserAccountDTO;
import com.sda.onlineshopfinalproject.entities.Cart;
import com.sda.onlineshopfinalproject.entities.UserAccount;
import com.sda.onlineshopfinalproject.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class UserAccountMapper {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserAccount map(UserAccountDTO userAccountDTO){
        return UserAccount.builder()
                .email(userAccountDTO.getEmail())
                .address(userAccountDTO.getAddress())
                .fullName(userAccountDTO.getFullName())
                .password(bCryptPasswordEncoder.encode(userAccountDTO.getPassword()))
                .userRole(UserRole.valueOf(userAccountDTO.getUserRole()))
                .cart(new Cart())
                .build();
    }


}
