package com.vidic.vidicbox.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="SUPPLIERS")
public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suppliersId;
    private String supplier;
    private List<Products> productsList;
}
