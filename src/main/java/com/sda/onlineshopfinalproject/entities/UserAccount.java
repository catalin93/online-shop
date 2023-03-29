package com.sda.onlineshopfinalproject.entities;

import com.sda.onlineshopfinalproject.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class UserAccount {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String fullName;


    private String address;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
