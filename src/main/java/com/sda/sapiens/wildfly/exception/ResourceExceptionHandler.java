package com.sda.sapiens.wildfly.exception;

import com.sda.sapiens.wildfly.model.dto.ErrorResponse;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class ResourceExceptionHandler implements ExceptionMapper<ProductAlreadyExistsException> {

    @Override
    public Response toResponse(ProductAlreadyExistsException exception) {
        return Response.status(Response.Status.FOUND)
                .entity(new ErrorResponse(
                        exception.getMessage(),
                        exception.getClass().getName(),
                        LocalDateTime.now()))
                .build();
    }
}
