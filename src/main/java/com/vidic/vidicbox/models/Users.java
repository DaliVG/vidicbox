package com.vidic.vidicbox.models;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @Column(name = "iduser")
    private Long idUser;
    @Column(name = "name")
    private String username;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy="user")
    private List<Products> productsList;
    public Users(String username, String password, List<Products> productsList) {
        this.username = username;
        this.password = password;
        this.productsList = productsList;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
