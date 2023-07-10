package com.vidic.vidicbox.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="pricereductions")
public class PriceReductions {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idPriceReduction;
    @Column(name = "name")
    private String priceReductionName;
    @Column(name = "amount")
    private Double priceReductionAmount;
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy="priceReductions")
    @JsonIgnore
    private List<Products> productsList;

    public PriceReductions(String priceReductionName, Double priceReductionAmount, Date startDate, Date endDate, List<Products> product) {
        this.priceReductionName = priceReductionName;
        this.priceReductionAmount = priceReductionAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productsList = product;
    }
    public void addProduct(Products product) {
        this.productsList.add(product);
    }
    public void removeProduct(Long idProduct) {
        Products product = this.productsList.stream().filter(t -> t.getIdProduct() == idProduct).findFirst().orElse(null);
        if (product != null) {
            this.productsList.remove(product);
        }
    }
    public Long getIdPriceReduction() {
        return idPriceReduction;
    }

    public void setIdPriceReduction(Long idPriceReduction) {
        this.idPriceReduction = idPriceReduction;
    }

    public String getPriceReductionName() {
        return priceReductionName;
    }

    public void setPriceReductionName(String priceReductionName) {
        this.priceReductionName = priceReductionName;
    }

    public Double getPriceReductionAmount() {
        return priceReductionAmount;
    }

    public void setPriceReductionAmount(Double priceReductionAmount) {
        this.priceReductionAmount = priceReductionAmount;
    }
}
