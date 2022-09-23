package com.jessikafujimura.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    public Cliente finById(@QueryParam("id") long id){
        return clienteService.findById(id);
    }

    @GET
    @Path("newCliente")
    public String newCliente(){
        Cliente cliente = Cliente.of(9, "Joana");
        return clienteService.newCliente(cliente);
    }

}
