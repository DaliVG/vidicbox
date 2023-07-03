package com.vidic.vidicbox.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "products")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idproducts")
    private Long idProduct;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "state")
    private String state;
    @Column(name = "supplierslist")
    private List<Suppliers> suppliersList;
    private Date creationDate;
    private Users user;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Suppliers> getSuppliersList() {
        return suppliersList;
    }

    public void setSuppliersList(List<Suppliers> suppliersList) {
        this.suppliersList = suppliersList;
    }
}
