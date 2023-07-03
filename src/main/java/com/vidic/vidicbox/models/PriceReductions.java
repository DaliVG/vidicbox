package com.vidic.vidicbox.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="pricereductions")
public class PriceReductions {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "pricereductions_id_seq")
    @SequenceGenerator(name = "pricereductions_id_seq", sequenceName = "pricereductions_id_seq", allocationSize = 1)
    @Column(name = "idpricereductions")
    private Long idPriceReduction;
    @Column(name = "name")
    private String priceReductionName;
    @Column(name = "amount")
    private Double priceReductionAmount;
    private Date StartDate;
    private Date EndDate;
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
