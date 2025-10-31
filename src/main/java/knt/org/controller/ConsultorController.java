package knt.org.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import knt.org.dto.ConsultorInputDto;
import knt.org.entity.Consultor;
import knt.org.service.ConsultorService;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;

import javax.print.DocFlavor;
import java.util.List;

@ApplicationScoped
@Path("/consultor")
public class ConsultorController {
    @Inject
    ConsultorService service;



    @GET
    @Path("/")
    public Response getAll(){

        return Response.ok(service.listAll()).build();
    }


    @POST
    @Path("/add-consultor")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addConsultor(ConsultorInputDto newConsultor){
        try {
            return Response.ok(service.addConsultor(newConsultor)).build();
        }
        catch (Exception e ){
            return Response.serverError().build();
        }
    }


}
