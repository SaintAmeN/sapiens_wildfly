package com.sda.sapiens.wildfly.resource;

import com.sda.sapiens.wildfly.model.dto.ProductDto;
import com.sda.sapiens.wildfly.service.ProductService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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

    // patrząc na to "co może zrobić użytkownik" piszemy kolejne metody:
    // - szukanie produktu po nazwie
    // - dodawanie produktów

    @GET
    @Path("/{phrase}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam(value = "phrase") String searchedPhrase) {
        log.info("Request to get products by searched phrase: " + searchedPhrase);

        // szukanie po frazie - użytkownik podaje słowo, jeśli słowo występuje w nazwie
        return Response
                .status(Response.Status.OK)
                .entity(productService.findProductsByName(searchedPhrase))
                .build();
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)   // mówi że ta metoda AKCEPTUJE format JSON
    public Response addProduct(ProductDto newProductInformation) {
        log.info("Request to add new product to offer: " + newProductInformation);

        // dodawanie produktu - jeśli istnieje produkt o takiej nazwie, to nie możemy dodać drugiego i spodziewamy sie bu-bu
        return Response
                .status(Response.Status.OK)
                .entity(productService.addProduct(newProductInformation))
                .build();
    }

}
