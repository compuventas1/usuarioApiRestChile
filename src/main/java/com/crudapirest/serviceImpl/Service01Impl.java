package com.crudapirest.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.crudapirest.model.Response;
import com.crudapirest.repository.UsuarioRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import com.crudapirest.model.Usuario;
import com.crudapirest.service.InterfaceService01;

@Slf4j
@Service
public class Service01Impl implements InterfaceService01 {

    @Autowired
    private UsuarioRepo repo;

    @Override
    public Response registrar(Usuario u) {

        //Método que busca el correo en la bd
        //Integer count = repo.traerCantidadBuscarCorreoUsuario(u.getEmail());

        Response res = new Response();
        int count=0;

        String email=u.getEmail();

        if (count == 0) {

            //Valida que el correo sea correcto
            Boolean val=validaEmail(email);
            log.info("val: "+val);
            if(val==true) {
                Usuario us = repo.save(u);

                res.setId(us.getId());
                res.setCreated(new Date());
                res.setModified(new Date());
                res.setLast_login(new Date());
                res.setIsactive("1");

                String token = getJWTToken(u.getName());
                res.setToken(token);
                res.setMensaje("Usuario creado correctamente.");
                log.info("Usuario creado correctamente.");
            }else{
                res.setMensaje("El correo no tiene un formato correcto.");
                log.info("El correo: "+email+", no tiene un formato correcto.");
            }
        } else {
            res.setMensaje("El correo ya existe en la base de datos.");
            log.info("El correo: " + u.getEmail() + ", ya existe en la base de datos.");
        }
        return res;
    }

    private String getJWTToken(String username) {

        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("JWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() * 180))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer  " + token;
    }

    @Override
    public List<Usuario> listar() {
        return repo.findAll();
    }

    public static Boolean validaEmail (String email) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
