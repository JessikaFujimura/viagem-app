package com.jessikafujimura.cliente;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.temporal.ChronoUnit;

@RegisterRestClient(baseUri = "http://localhost:8181/cliente")
public interface ClienteService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("findById")
    @Timeout(unit = ChronoUnit.SECONDS, value = 3)
    @Fallback(fallbackMethod = "falback")
    @CircuitBreaker(
            requestVolumeThreshold = 4, // número de requesições
            failureRatio = .5, //Porcentagem de falha em relação a sua amostra
            delay = 6000,  //depois que um tempo tenta denovo
            successThreshold = 1 //taxa de sucesso
    )
    public Cliente findById(@QueryParam("id") long id);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String newCliente(Cliente cliente);

    private Cliente falback(long id){
        return Cliente.of(0, "NINGUÉM");
    }
}
