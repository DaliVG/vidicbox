package com.vidic.vidicbox.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "products")
public class Products {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idProduct;
    @Column(name = "itemCode")
    private String itemCode;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "state")
    private String state;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "products_suppliers",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_supplier"))
    @Column(name = "suppliersList")
    private List<Suppliers> suppliersList;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name="id_user", nullable=true)
    private Users user;
    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="id_price_reductions", nullable=true)
    private PriceReductions priceReductions;

    public Products(String itemCode, String description) {
        this.itemCode = itemCode;
        this.description = description;
        this.state = "Active";
        this.creationDate = new Date();
        this.priceReductions= null;
        this.user = user;
    }

    public void addSupplier(Suppliers supplier) {
        this.suppliersList.add(supplier);
    }
    public void removeSupplier(Long idSupplier) {
        Suppliers supplier = this.suppliersList.stream().filter(t -> t.getIdSupplier() == idSupplier).findFirst().orElse(null);
        if (supplier != null) {
            this.suppliersList.remove(supplier);
        }
    }

    public List<Suppliers> getSuppliersList() {
        return suppliersList;
    }

    public void setSuppliersList(List<Suppliers> suppliersList) {
        this.suppliersList = suppliersList;
    }
    public PriceReductions getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(PriceReductions priceReductions) {
        this.priceReductions = priceReductions;
    }
}
