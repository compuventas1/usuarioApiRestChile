package com.crudapirest.controller;

import java.util.List;

import com.crudapirest.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crudapirest.service.InterfaceService01;
import com.crudapirest.model.Usuario;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private InterfaceService01 service;

    @PostMapping("/crearusuario")
    public Response registrar(@RequestBody Usuario usuario) {
        try {
            return service.registrar(usuario);
        }catch (Exception ex){
            log.info("Error: "+ex.getMessage());
            return null;
        }
    }

    @GetMapping("/listarusuarios")
    public List<Usuario> listar() {

        return service.listar();
    }
}