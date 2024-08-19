package com.crudapirest;

import com.crudapirest.model.Phones;
import com.crudapirest.model.Usuario;
import com.crudapirest.repository.UsuarioRepo;
import com.crudapirest.serviceImpl.Service01Impl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

class Service01ImplTest {


    @Mock
    private UsuarioRepo repo;

    @InjectMocks
    private Service01Impl service01;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        Usuario us = new Usuario();
        us.setId(1);
        us.setName("Jorge Ramiro");
        us.setEmail("jramiro@gmail.com");
        us.setPassword("A#<b123");

        Phones p = new Phones();
        p.setIdPhone(1);
        p.setNumber("90949384");
        p.setContrycode("+51");
        p.setCitycode("1");

        List<Phones> ls = new ArrayList<>();
        ls.add(p);
        us.setPhones(ls);

        us.setIsactive("1");
    }

    @Test
    void registrar() throws Exception {
        when(repo.save(any(Usuario.class))).thenReturn(usuario);
        //assertTrue(service01.registrar(new Usuario()));
    }

    @Test
    void listar() throws Exception {
        when(repo.findAll()).thenReturn(Arrays.asList(usuario));
        assertNotNull(service01.listar());
    }
}