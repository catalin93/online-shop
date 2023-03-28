package com.sda.onlineshopfinalproject.validator;

import com.sda.onlineshopfinalproject.dto.UserAccountDTO;
import com.sda.onlineshopfinalproject.entities.UserAccount;
import com.sda.onlineshopfinalproject.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.naming.Binding;
import java.util.Optional;

@Component
public class UserAccountValidator {

    @Autowired
    private UserAccountRepository userAccountRepository;
    public void validate (UserAccountDTO userAccountDTO, BindingResult bindingResult){
        Optional<UserAccount> optionalUserAccount = userAccountRepository.findByEmail(userAccountDTO.getEmail());
        if(optionalUserAccount.isPresent()){
            FieldError fieldError = new FieldError("userAccountDTO","email","ERROR: Email already in use");
            bindingResult.addError(fieldError);
        }
    }


}
