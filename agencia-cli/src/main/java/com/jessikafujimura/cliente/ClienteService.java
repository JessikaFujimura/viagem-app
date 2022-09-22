package com.jessikafujimura.cliente;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public Cliente findById(@QueryParam("id") long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String newCliente(Cliente cliente);
}
