package com.vidic.vidicbox.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "products_suppliers",
            joinColumns = @JoinColumn(name = "id_product"),
            inverseJoinColumns = @JoinColumn(name = "id_supplier"))
    @Column(name = "suppliersList")
    private List<Suppliers> suppliersList;
    private Date creationDate;
    @ManyToOne
    @JoinColumn(name="user_id_seq", nullable=false)
    private Users user;
    @ManyToOne
    @JoinColumn(name="pricereductions_id_seq", nullable=true)
    private PriceReductions priceReductions;

    public Products(String description, Double price, Users user) {
        this.description = description;
        this.price = price;
        this.state = "Active";
        this.creationDate = new Date();
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
    public PriceReductions getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(PriceReductions priceReductions) {
        this.priceReductions = priceReductions;
    }
}
