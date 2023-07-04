package com.vidic.vidicbox.controllers;

import com.vidic.vidicbox.models.Products;
import com.vidic.vidicbox.services.ProductsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    ProductsServices productsServices;

    @GetMapping("/products/list")
    private List getAllProducts() {
        List<Products> list = productsServices.getAllProducts().stream().toList();
        return list;
    }

    @GetMapping("/products/{productId}")
    private Products getProductById(@PathVariable("productId") Long productId) {
        return productsServices.getProductById(productId);
    }

    @PostMapping("/createproduct")
    private ResponseEntity createProducts(@RequestBody Products product) {
        try {
            productsServices.saveOrUpdate(product);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("New product created with description: " + product.getDescription(), HttpStatus.CREATED);
    }


    @DeleteMapping("/products/{id}")
    private ResponseEntity deleteById(@PathVariable("productId") Long productId) {
        try {
            productsServices.delete(productId);
        } catch (Exception exception) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity("Product deleted with id: " + productId, HttpStatus.OK);
    }
}
