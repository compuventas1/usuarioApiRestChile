# crearusuarioApiRestJwtJpaJunitMockito

<!-- ===============================================-->
<!--  Guia de instalación y configuración    -->
<!-- ===============================================-->

La base de datos se crea en memoria con H2 console, JPA automáticamente crea las tablas
al momento de levantar la api RESTful.

Realizar un clean install para que descargue los repositorios maven desde el pom.xml

De preferencia poner la configuración de maven la carpeta m2 en el diso C:\.m2 para que no tenga conflictos de permisos al descargar el repositorio o espacio de disco.

Levantar el proyecto con IntelliJ en mi caso en opciones de arranque Run as Maven y poner comando spring-boot:run en mi caso estoy usando JDK20 y apache-maven-3.9.3-bin

Una vez el proyecto este levantado utilizar postman para testear las apis.

Utilizo 2 tipos de apis la primera localhost:8080/user para obtener el token.
    
    POST http://localhost:8080/user

En la pestaña Body en postman poner Key user, Value jerjes luego Key password, value pwd, ojo poner los parámetros.
con esos nombres.

Me genera un token de authenticacion en JSON 
    
    {
		"user": "jerjes",
		"token": "Bearer  eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJKV1QiLCJzdWIiOiJqZXJqZXMiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNzE0OTc2NTI2LCJleHAiOjMwODY5NTc3NDc1OH0.wr8nr_yWmlb5to0isomOeSNF-cEidQTc4n-30CBiOGRdy1Mdf5ixml8qrREqEWDwqpYHYvYaHhorvQ_SN5XT6A"
	}

Una vez obtenido el token paso a testear las apis.
    
En la pestaña Headers de postman ingreso en Key Authorization y en value el valor del token generado arriba lo mismo se 
tendrá que poner a todas las apis, el token esta configurado para vencer en 1 hora.

    POST http://localhost:8080/api/usuarios/crearusuario
		
    {
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "hunter2",
        "phones": [
            {
                "number": "1234567",
                "citycode": "1",
                "contrycode": "57"
            }
        ],
        "isactive": "1"
    }

Para poder visualizar si creó el usuario correctamente, accedemos a la interfaz gráfica de H2 console:
en el navegador ingresamos:

http://localhost:8080/h2-console/
    
    usuario: sa
    password: password

Digitamos SELECT * FROM USUARIO;

Luego para poder visualizar la documentación de la api escribimos lo siguiente en el navegador.

http://localhost:8080/swagger-ui/index.html

Finalmente revisamos los test unitarios con Junit y Mockito me dirijo a la carpeta Test en la parte inferior del proyecto y busco el archivo
Service01ImplTest selecciono el archivo y doy click derecho Run Service01ImplTest o sino lo ejecuto con cobertura Run Service01ImplTest with Coverage.
	