package com.vidic.vidicbox.controllers;

import com.vidic.vidicbox.models.Products;
import com.vidic.vidicbox.services.PriceReductionServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PriceReductionController {
    @Autowired
    PriceReductionServices priceReductionServices;

    @GetMapping("/pricereduction/list")
    private List getAllPriceReductions() {
        List<Products> list = priceReductionServices.getAllPriceReductions().stream().toList();
        return list;
    }
}
