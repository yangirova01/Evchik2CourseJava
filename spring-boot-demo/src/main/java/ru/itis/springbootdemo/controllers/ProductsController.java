package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.ProductDto;
import ru.itis.springbootdemo.dto.ProductDtoForRequst;
import ru.itis.springbootdemo.services.ProductService;

import java.util.List;

@Controller
public class ProductsController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getUsersPage(Model model) {
        return "products";
    }

    @GetMapping("/products/{price}/{size}")
    @ResponseBody
    public ResponseEntity<List<ProductDto>> getProducts(@PathVariable("size") String size, @PathVariable("price") String price) {
        if (price != null && size != null) {
            return ResponseEntity.ok(productService.getProductBySizeAndPrice(size, Integer.parseInt(price)));
        }
    return null;
    }

    @PostMapping("/products")
    public ResponseEntity<List<ProductDto>> postProduct(@RequestBody ProductDtoForRequst productDto){
        return getProducts(productDto.getSize(),productDto.getPrice());
    }


}
