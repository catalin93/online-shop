package com.sda.onlineshopfinalproject.controller;


import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.dto.ProductQuantityDTO;
import com.sda.onlineshopfinalproject.dto.UserAccountDTO;
import com.sda.onlineshopfinalproject.service.ProductService;
import com.sda.onlineshopfinalproject.service.UserAccountService;
import com.sda.onlineshopfinalproject.validator.UserAccountValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private UserAccountValidator userAccountValidator;


    @GetMapping("/addProduct")
    public String addProductGet(Model model){
        ProductDTO productDTO = new ProductDTO();
        model.addAttribute("productDTO",productDTO);
        //aici implementam fancy "Bussines logic"
        return "addProduct";

    }
    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute ProductDTO productDTO ,@RequestParam("productImg") MultipartFile multipartFile){
        System.out.println(productDTO);
        log.info("Am adaugat un produs");
        productService.add(productDTO, multipartFile);
        return "redirect:/addProduct";
    }

    @GetMapping("/homePage")
    public String homePageGet(Model model){

        List<ProductDTO> productDTOList = productService.getAllProductDTO();
        model.addAttribute("productDTOList",productDTOList);
        System.out.println(productDTOList);
        return "homePage";
    }
    @GetMapping("/product/{id}")
    public String viewProductGet (Model model,@PathVariable(value = "id") String id){
        System.out.println("Am dat click pe produsul cu id " +id);
        Optional<ProductDTO> optionalProductDTO = productService.getProdactDTOById(id);
        if(optionalProductDTO.isEmpty()){
            // accesam o pagina de eroare
            return "errorPage";
        }
        model.addAttribute("productDTO",optionalProductDTO.get());
        ProductQuantityDTO productQuantityDTO = new ProductQuantityDTO();
        model.addAttribute("productQuantityDTO", productQuantityDTO);
        return "viewProduct";
    }

    @PostMapping("/product/{id}")
    public String addToCartPost(@ModelAttribute ProductQuantityDTO productQuantityDTO,
                                @PathVariable(value = "id") String id,
                                Authentication authentication){
        System.out.println("Cantitatea este : " + productQuantityDTO);
        System.out.println("Adaun in cos produsul cu id: " + id);
        System.out.println("Email: " + authentication.getName());
        return "redirect:/product/"+id;
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        UserAccountDTO userAccountDTO = new UserAccountDTO();
        model.addAttribute("userAccountDTO",userAccountDTO);
        return "redirect:/product/";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute UserAccountDTO userAccountDTO, BindingResult bindingResult){
        System.out.println(userAccountDTO);
        userAccountValidator.validate(userAccountDTO, bindingResult);
        if(bindingResult.hasErrors()){
            return "register";
        }
        userAccountService.addUserAccount(userAccountDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginGet(){

        return "login";
    }


}
