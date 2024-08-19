package com.crudapirest.model;


import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Phones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPhone;

    @Column(name = "number", nullable = false, length = 10)
    private String number;

    @Column(name = "citycode", nullable = false, length = 5)
    private String citycode;

    @Column(name = "countrycode", nullable = false, length = 5)
    private String contrycode;

}
