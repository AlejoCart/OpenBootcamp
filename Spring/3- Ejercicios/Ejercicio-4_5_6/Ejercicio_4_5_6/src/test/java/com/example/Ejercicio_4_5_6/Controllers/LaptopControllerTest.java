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
    @DisplayName("Comprobar findAll")
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
    void findOneById() {
        ResponseEntity<Laptop[]> response=
                testRestTemplate.getForEntity("/api/Laptop/1", Laptop[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        System.out.println(response.getBody());
    }

    @Test
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
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void deleteAll() {
    }
}