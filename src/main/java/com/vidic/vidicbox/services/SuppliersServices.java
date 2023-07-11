package com.vidic.vidicbox.services;

import com.vidic.vidicbox.models.Suppliers;
import com.vidic.vidicbox.repositories.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SuppliersServices {
    @Autowired
    SuppliersRepository suppliersRepository;

    public List getAllSuppliers() {
        List suppliersList = new ArrayList();
        suppliersRepository.findAll().forEach(supplier -> suppliersList.add(supplier));
        return suppliersList;
    }

    public Suppliers getSupplierById(Long idSupplier) {
        return suppliersRepository.findById(idSupplier).get();
    }

    public void saveOrUpdate(Suppliers supplier) {
        suppliersRepository.save(supplier);
    }

    public void delete(Long idSupplier) {
        suppliersRepository.deleteById(idSupplier);
    }
}
