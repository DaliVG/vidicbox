package com.vidic.vidicbox.models;

import javax.persistence.*;

@Entity
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1, schema = "erp")
    @Column(name = "iduser")
    private Long idUser;
    @Column(name = "user_name")
    private String username;
    @Column(name = "user_password")
    private String password;
}
