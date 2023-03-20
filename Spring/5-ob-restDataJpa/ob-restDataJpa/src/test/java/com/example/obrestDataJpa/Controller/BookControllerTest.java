package com.example.obrestDataJpa.Controller;

import com.example.obrestDataJpa.Entities.Book;
import io.swagger.models.Response;
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

@SpringBootTest (webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;
    @BeforeEach
    void setUp() {
        restTemplateBuilder=
                restTemplateBuilder.rootUri("http://localhost:"+port);
        testRestTemplate= new TestRestTemplate(restTemplateBuilder);
    }
    @DisplayName("Comprobar hola mundo desde controlador REST")
    @Test
    void hello() {
        ResponseEntity<String> result= testRestTemplate.getForEntity("/api" +
                        "/hola",
                String.class);
        assertEquals(HttpStatus.OK,result.getStatusCode());
        assertEquals("Hola mundo que tal todo?",result.getBody());

    }
    @Test
    void findAll() {
        ResponseEntity<Book[]> response=
        testRestTemplate.getForEntity("/api/Books/", Book[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        List<Book> books=Arrays.asList(response.getBody());
        System.out.println(books.size());
    }

    @Test
    void findById() {
        ResponseEntity<Book[]> response=
                testRestTemplate.getForEntity("/api/Books/1", Book[].class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());

    }

    @Test
    void create() {//Broken

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String json= """
                {
                    "title": "Libro de testeo v0.1_Testing",
                    "autor": "Paulo Coelo",
                    "pagesNum": 554,
                    "price": 69.99,
                    "available": true,
                    "stock": 100,
                    "releaseDate": "2025-12-24"
                }""";
        HttpEntity <String> request = new HttpEntity<>(json,headers);
        ResponseEntity<Book> response=testRestTemplate.exchange("/api/Books",
                HttpMethod.POST,request,
                Book.class);

        Book result= response.getBody();
        assertEquals(1L,result.getId());

    }
}