package com.vidic.vidicbox.services;

import com.vidic.vidicbox.models.PriceReductions;
import com.vidic.vidicbox.repositories.PriceReductionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceReductionServices {
    @Autowired
    PriceReductionsRepository priceReductionsRepository;

    public List getAllPriceReductions() {
        List priceReductionsList = new ArrayList();
        priceReductionsRepository.findAll().forEach(priceReductions -> priceReductionsList.add(priceReductions));
        return priceReductionsList;
    }

    public PriceReductions getPriceReductionsById(Long priceReductionsId) {
        return priceReductionsRepository.findById(priceReductionsId).get();
    }

    public void saveOrUpdate(PriceReductions priceReductions) {
        priceReductionsRepository.save(priceReductions);
    }

    public void delete(Long priceReductionsId) {
        priceReductionsRepository.deleteById(priceReductionsId);
    }
}
