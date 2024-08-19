package com.crudapirest.model;

import lombok.Data;

import java.util.Date;

@Data
public class Response {

    private int id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private String isactive;
    private String mensaje;

}
