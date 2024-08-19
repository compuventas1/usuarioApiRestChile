package com.crudapirest.service;

import com.crudapirest.model.Response;
import com.crudapirest.model.Usuario;

import java.util.List;

public interface InterfaceService01 {

    public Response registrar(Usuario u);

    public List<Usuario> listar();

}
