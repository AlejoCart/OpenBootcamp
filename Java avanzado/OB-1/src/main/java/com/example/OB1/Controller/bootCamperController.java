package com.example.OB1.Controller;

import com.example.OB1.Models.bootCamper;
import com.example.OB1.Service.bootCamperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Component
@Path("/")
@AllArgsConstructor
public class bootCamperController {


    /*@GET
    @Path("/saludo")
    public String saludo(){
        return "HelloWorld";
    }*/

    private final bootCamperService servicio;

    @GET
    @Path("/bootCampers")
    @Produces("application/json")
    public List<bootCamper> findAll(){
        return servicio.getAll();
    }

    @GET
    @Path("/bootcampers/{id}")
    @Produces("application/json")
    public bootCamper findById(@PathParam("id")Long id){
        return servicio.findById(id);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response add(bootCamper auxBoot){
        servicio.add(auxBoot);
        return  Response.created
                (URI.create("/bootcampers/" + auxBoot.getName()))
                .build();
    }

}
