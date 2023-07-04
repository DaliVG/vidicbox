package com.vidic.vidicbox.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name= "products")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "products_id_seq")
    @SequenceGenerator(name = "products_id_seq", sequenceName = "products_id_seq", allocationSize = 1)
    private Long idProduct;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "state")
    private String state;
    @ManyToMany
    @Column(name = "suppliersList")
    @JsonIgnore
    private List<Suppliers> suppliersList;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name="user_id_seq", nullable=false)
//    @JsonIgnore
    private Users user;
    @ManyToOne
    @JoinColumn(name="pricereductions_id_seq", nullable=true)
//    @JsonIgnore
    private PriceReductions priceReductions;

    public Products(String description, Double price, String state, Users user) {

        List<Suppliers> suppliersList = new ArrayList<>();
        this.description = description;
        this.price = price;
        this.state = state;
        this.suppliersList = suppliersList;
        this.creationDate = new Date();
        this.user = user;
    }

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
