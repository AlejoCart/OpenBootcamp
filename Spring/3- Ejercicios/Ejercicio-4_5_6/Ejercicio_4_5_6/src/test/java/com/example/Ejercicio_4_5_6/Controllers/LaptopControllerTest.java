package com.example.Ejercicio_4_5_6.Controllers;

import com.example.Ejercicio_4_5_6.Entities.Laptop;
import com.example.Ejercicio_4_5_6.Repositories.LaptopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @Autowired
    private LaptopRepository repo;

    @BeforeEach
    void setUp(){
        restTemplateBuilder=restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate= new TestRestTemplate(restTemplateBuilder);
        repo.save(new Laptop(null,"Laptop para testing","0.01"));
    }
    @DisplayName("Encontrar todos los elementos")
    @Test
    void findAll() {

        //repo.save(new Laptop());
        ResponseEntity<Laptop[]> response=
                testRestTemplate.getForEntity("/api" +
                "/Laptops/", Laptop[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<Laptop> laptops= Arrays.asList(response.getBody());
        System.out.println(laptops.size());
        System.out.println(laptops.stream().findAny());
        //assertEquals(1,laptops.size());
        }


    @Test
    @DisplayName("Encontrar elemento por id")
    void findOneById() {
        ResponseEntity<Laptop[]> response=
                testRestTemplate.getForEntity("/api/Laptop/1", Laptop[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        System.out.println(response.getBody());
    }

    @Test
    @DisplayName("Encontrar todos los elementos")
    void create() {

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                    {
                         "marca": "Marca De testing",
                         "modelo": "0.01"
                     }""";
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        //System.out.println(request.getBody());
        //System.out.println(request.getHeaders());
        ResponseEntity<Laptop> response;
        response = testRestTemplate.exchange("/api" +
                        "/Laptops",
                HttpMethod.POST,request,
                Laptop.class);
        Laptop result= response.getBody();
        System.out.println(result);
        assertEquals(2L,result.getId());

    }
    //
    //
    // In progress
    //
    //
    @Test
    @DisplayName("Actualizar informacion del objeto ")
    void update() {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                    {    "id":1,
                         "marca": "Marca De testing update",
                         "modelo": "0.02"
                     }""";
        HttpEntity<String> request = new HttpEntity<>(json,headers);
        //System.out.println(request.getBody());
        //System.out.println(request.getHeaders());
        ResponseEntity<Laptop> response;
        response = testRestTemplate.exchange("/api" +
                        "/Laptop/update",
                HttpMethod.PUT,request,
                Laptop.class);
        Laptop result= response.getBody();
        System.out.println(result);
        //assertEquals(1L,result.getId());
        assertEquals("0.02",result.getModelo());

    }

    @Test
    @DisplayName("Borrar elemento por id")
    void deleteById() {
        Long id=1L;
        ResponseEntity response;
        response = testRestTemplate.exchange("/api" +
                        "/Laptop/delete/"+id,
                HttpMethod.DELETE,null,
                ResponseEntity.class);

        System.out.println(response.getStatusCode().value());
        assertEquals(200,response.getStatusCode().value());

        id=-1L;
        response = testRestTemplate.exchange("/api" +
                        "/Laptop/delete/"+id,
                HttpMethod.DELETE,null,
                ResponseEntity.class);
        System.out.println(response.getStatusCode().value());
        assertEquals(404,response.getStatusCode().value());

    }


    //Broken ¯\_(ツ)_/¯
    @Test
    @DisplayName("Borrar todos los elementos")
    void deleteAll() {
        ResponseEntity response;
        response = testRestTemplate.exchange("/api" +
                        "/Laptop/deleteAll",
                HttpMethod.DELETE, null,
                ResponseEntity.class);

        /*response = testRestTemplate.exchange("/api" +
                        "/Laptop/delete/"+id,
                HttpMethod.DELETE,null,
                ResponseEntity.class);*/

        assertEquals(404,response.getStatusCode().value());
        //Limpiando repositorio
        repo.deleteAll();

        response = testRestTemplate.exchange("/api" +
                        "/Laptop/deleteAll/",
                HttpMethod.DELETE,null,
                ResponseEntity.class);

        assertEquals(204,response.getStatusCode().value());
    }
}