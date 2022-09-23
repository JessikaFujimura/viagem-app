package com.jessikafujimura.reserva;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path(("/reserva"))
public class ReservaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> getReservas(){
        return Reserva.listAll();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Reserva postReserva(Reserva reserva){
        reserva.id = null;
        reserva.persist();
        return reserva;
    }
}
