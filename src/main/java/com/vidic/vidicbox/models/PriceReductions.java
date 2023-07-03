package com.vidic.vidicbox.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PRICEREDUCTIONS")
public class PriceReductions {
    private Long priceReductionId;
    private String priceReductionName;
    private Double priceReductionAmount;
}
