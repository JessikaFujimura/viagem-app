package com.jessikafujimura.reserva;

import com.jessikafujimura.cliente.ClienteService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reserva-cli")
public class ReservaResource {

    @Inject
    @RestClient
    ReservaService reservaService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("newReserva")
    public String newReserva(){
        Reserva reserva = Reserva.of(0, 2);
        return reservaService.newReserva(reserva);
    }
}