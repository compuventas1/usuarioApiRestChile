package com.crudapirest.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.crudapirest.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Integer> {

}
