package knt.org.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.NoResultException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import knt.org.dto.DemandaInputDto;
import knt.org.service.DemandaService;
import org.hibernate.NonUniqueResultException;

@ApplicationScoped
@Path("/demanda")
public class DemandaController {

    @Inject
    DemandaService service;


    @GET
    @Path("/")
    public Response getAll(){
        return  Response.ok(this.service.getAll()).build();
    }

    @POST
    @Path("nova-demanda")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newDemanda(DemandaInputDto input){
        try {
            return Response.ok(service.createDemanda(input)).build();
        }catch (NonUniqueResultException| NoResultException e){
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(),e.getMessage()).build();
        }
    }

}
