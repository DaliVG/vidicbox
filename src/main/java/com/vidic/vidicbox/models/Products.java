package com.vidic.vidicbox.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "PRODUCTS")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private Double price;
    private String state;
    private List<Suppliers> suppliersList;

}
