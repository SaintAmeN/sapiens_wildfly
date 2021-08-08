package com.sda.sapiens.wildfly.exception;

import com.sda.sapiens.wildfly.model.dto.ErrorResponse;
import jakarta.ejb.EJBException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.time.LocalDateTime;

@Provider
public class ResourceExceptionMapper implements ExceptionMapper<EJBException> {

    @Override
    public Response toResponse(EJBException exception) {
        return Response.status(Response.Status.FOUND)
                .entity(new ErrorResponse(
                        exception.getMessage(),
                        exception.getClass().getName(),
                        LocalDateTime.now()))
                .build();
    }
}
