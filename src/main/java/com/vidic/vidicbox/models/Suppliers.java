package com.vidic.vidicbox.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@Table(name="suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @SequenceGenerator(name = "supplier_id_seq", sequenceName = "supplier_id_seq", allocationSize = 1)
    @Column(name = "idsupplier")
    private Long idSupplier;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "country")
    private String country;
    @ManyToMany
    @Column(name = "productlist")
    private List<Products> productsList;

    public Suppliers(String supplier, String country, List<Products> productsList) {
        this.supplier = supplier;
        this.country = country;
        this.productsList = productsList;
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
