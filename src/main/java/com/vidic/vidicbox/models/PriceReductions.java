package com.vidic.vidicbox.models;

import javax.persistence.*;

@Entity
@Table(name="pricereductions")
public class PriceReductions {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "pricereductions_id_seq")
    @SequenceGenerator(name = "pricereductions_id_seq", sequenceName = "pricereductions_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idpricereductions")
    private Long idPriceReduction;
    @Column(name = "name")
    private String priceReductionName;
    @Column(name = "amount")
    private Double priceReductionAmount;
}
