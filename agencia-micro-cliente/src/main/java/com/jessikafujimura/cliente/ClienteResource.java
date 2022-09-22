package com.jessikafujimura.cliente;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("/cliente")
public class ClienteResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes(){
        return Cliente.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente getClienteById(@QueryParam("id") long id){
        return Cliente.findById(id);
    }

    @Transactional // operação que faz mudança no banco de dados
    @DELETE
    @Path("deleteById")
    public void deleteCliente(@QueryParam("id") long id){
        Cliente.deleteById(id);
    }

    @Transactional //
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postCliente(Cliente cliente){
        cliente.id = null; //certificar de que o id é nulo senão é atualizado a cliente.
        cliente.persist();
        return Response.status(Status.CREATED).entity(cliente).build();
    }
}
