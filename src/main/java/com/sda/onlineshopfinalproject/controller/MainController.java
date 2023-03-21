package com.sda.onlineshopfinalproject.controller;


import com.sda.onlineshopfinalproject.dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/addProduct")
    public String addProductGet(Model model){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Telefon");
        model.addAttribute("productDTO",productDTO);
        //aici implementam fancy "Bussines logic"
        return "addProduct";
    }
    @PostMapping("/addProduct")
    public String addProductPost(){

        log.info("Am adaugat un produs");
        return "redirect:/addProduct";
    }
}
