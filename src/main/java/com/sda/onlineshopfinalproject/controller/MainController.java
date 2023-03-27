package com.sda.onlineshopfinalproject.controller;


import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
public class MainController {
    @Autowired
   private ProductService productService;



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
        return "viewProduct";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }
}