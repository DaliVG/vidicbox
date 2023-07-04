package com.vidic.vidicbox.services;

import com.vidic.vidicbox.models.Products;
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

    public List<Products> getAllProducts() {
        List<Products> productsList = new ArrayList();
        productsRepository.findAll().forEach(product -> productsList.add(product));
        return productsList;
    }

    public Products getProductById(Long productId) {
        return productsRepository.findById(productId).orElseThrow(()-> new EntityNotFoundException("No se ha encontrado el id en BBDD."));
    }

    public void saveOrUpdate(Products product) {
        productsRepository.save(product);
    }

    public void delete(Long productId) {
        productsRepository.deleteById(productId);
    }
}
