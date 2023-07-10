package com.vidic.vidicbox.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idUser;
    @Column(name = "name")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
    @OneToMany(mappedBy="user")
    @JsonIgnore
    private List<Products> productsList;
    public Users(String username, String password, List<Products> productsList) {
        this.username = username;
        this.password = password;
        this.productsList = productsList;
    }
}
