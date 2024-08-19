package com.crudapirest.repository;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

@Slf4j
public class UsuarioRepoImpl{
    @Autowired
    EntityManager em;

    public Integer traerCantidadBuscarCorreoUsuario(String correo) {
        String query = "select count(email) from usuario where email=" + correo;

        Integer result = (Integer) em.createNativeQuery(query).getSingleResult();
        log.info("result: " + result);
        return result;
    }

}
