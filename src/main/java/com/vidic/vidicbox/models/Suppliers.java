package com.vidic.vidicbox.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idSupplier;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "country")
    private String country;
    @ManyToMany(mappedBy = "suppliersList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @Column(name = "productlist")
    private List<Products> productsList;

    public Suppliers(String supplier, String country) {
        this.supplier = supplier;
        this.country = country;
    }
    public void addProduct(Products product) {
        this.productsList.add(product);
    }
    public void removeProduct(Long idProduct) {
        Products product = this.productsList.stream().filter(t -> Objects.equals(t.getIdProduct(), idProduct)).findFirst().orElse(null);
        if (product != null) {
            this.productsList.remove(product);
            product.setPriceReductions(null);
        }
    }
    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
