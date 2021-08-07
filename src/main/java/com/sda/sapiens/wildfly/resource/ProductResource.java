package com.sda.sapiens.wildfly.resource;

import com.sda.sapiens.wildfly.service.ProductService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.java.Log;

// ....../api/product
@Log
@Stateless
@Path("/product")
public class ProductResource {
    @Inject
    private ProductService productService;
    // używamy domyślnego konstruktora do stworzenia instancji klasy
    // inject używa settera do ustawienia pola.

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        log.info("Request to get all products.");

        return Response
                .status(Response.Status.OK)
                .entity(productService.findAll())
                .build();
    }

}
