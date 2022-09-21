package com.jessikafujimura.reserva;

import com.jessikafujimura.cliente.Cliente;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    ReservaService reservaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getReserva")
    public Response getReserva(){
        Cliente cliente = Cliente.of(2, "Maria");
        Reserva reserva = reservaService.newReserva(cliente);
        return Response.status(Status.CREATED).entity(reserva).build();
    }
}