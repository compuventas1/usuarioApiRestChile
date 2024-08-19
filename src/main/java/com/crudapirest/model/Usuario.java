package com.crudapirest.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 15)
    private String password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phones> phones = new ArrayList<>();

    @Column(name="isactive", nullable = false, length = 4)
    private String isactive;

}
