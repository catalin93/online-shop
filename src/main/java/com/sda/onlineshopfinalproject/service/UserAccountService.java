package com.sda.onlineshopfinalproject.service;

import com.sda.onlineshopfinalproject.dto.UserAccountDTO;
import com.sda.onlineshopfinalproject.entities.UserAccount;
import com.sda.onlineshopfinalproject.mapper.UserAccountMapper;
import com.sda.onlineshopfinalproject.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {


    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private UserAccountRepository userAccountRepository;
    public void addUserAccount(UserAccountDTO userAccountDTO){
        UserAccount userAccount = userAccountMapper.map(userAccountDTO);

        userAccountRepository.save(userAccount);
    }


}
