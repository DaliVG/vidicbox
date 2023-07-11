package com.vidic.vidicbox.services;

import com.vidic.vidicbox.models.Products;
import com.vidic.vidicbox.repositories.PriceReductionsRepository;
import com.vidic.vidicbox.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServices {
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    PriceReductionsRepository priceReductionsRepository;

    public List<Products> getAllProducts() {
        List<Products> productsList = new ArrayList<>();
        productsRepository.findAll().forEach(product -> productsList.add(product));
        return productsList;
    }

    public Products getProductById(Long productId) {
        return productsRepository.findById(productId).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el id en BBDD."));
    }

    public void save(Products product) {
        Products jeje = new Products(product.getItemCode(), product.getDescription());
        productsRepository.save(jeje);
    }

    public void update(Products product) {
            productsRepository.save(product);
    }

    public void delete(Long productId) {
        Products productToDelete = productsRepository.findById(productId).orElse(null);
        if(productToDelete.getPriceReductions().getIdPriceReduction()!=0){
            productToDelete.setPriceReductions(null);
        }
        productsRepository.deleteById(productId);
    }
}
