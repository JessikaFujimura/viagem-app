package com.jessikafujimura.cliente;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/cliente-cli")
public class ClienteResource {

    @Inject
    @RestClient
    ClienteService clienteService;

    @GET
    @Path("getCliente")
    public Response getCliente(){
        Cliente cliente = Cliente.of(9, "Joana");

        Response response = clienteService.newCliente(cliente);

        return Response.status(Status.CREATED).entity(response).build();
    }

}
