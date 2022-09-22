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
    @Path("getReserva")
    public String getReserva(){
        Reserva reserva = Reserva.of(1L, 2L);
        return reservaService.newReserva(reserva);
    }
}