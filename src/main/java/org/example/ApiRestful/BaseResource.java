package org.example.ApiRestful;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("")
public class BaseResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listarProdutos() {
        return "Raiz da API";
    }

}
