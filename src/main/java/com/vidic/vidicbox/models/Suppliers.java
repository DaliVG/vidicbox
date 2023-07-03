package com.vidic.vidicbox.models;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="suppliers")
public class Suppliers {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @SequenceGenerator(name = "supplier_id_seq", sequenceName = "supplier_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "idsupplier")
    private Long idSupplier;
    @Column(name = "supplier")
    private String supplier;
    @Column(name = "productlist")
    private List<Products> productsList;
}
