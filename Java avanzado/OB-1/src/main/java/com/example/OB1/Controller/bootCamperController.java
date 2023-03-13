package com.example.OB1.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Component
@Path("/")
@AllArgsConstructor
public class bootCamperController {


    @GET
    @Path("/saludo")
    public String saludo(){
        return "HelloWorld";
    }
}
