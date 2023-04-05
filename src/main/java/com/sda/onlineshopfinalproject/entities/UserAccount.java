package com.sda.onlineshopfinalproject.entities;

import com.sda.onlineshopfinalproject.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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


    //cascade = CascadeType.ALL    -   se foloseste pentru a salva CArt automat
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn
    private Cart cart;

    @OneToMany(mappedBy = "userAccount")
    private List<Order> orderList;

}
