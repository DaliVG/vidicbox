package com.vidic.vidicbox.models;

import javax.persistence.*;
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

}
