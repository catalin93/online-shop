package com.sda.onlineshopfinalproject.controller;


import com.sda.onlineshopfinalproject.dto.ProductDTO;
import com.sda.onlineshopfinalproject.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String addProductPost(@ModelAttribute ProductDTO productDTO){
        System.out.println(productDTO);
        log.info("Am adaugat un produs");
        productService.add(productDTO);
        return "redirect:/addProduct";
    }

    @GetMapping("/homePage")
    public String homePageGet(){
        return "homePage";
    }
}
