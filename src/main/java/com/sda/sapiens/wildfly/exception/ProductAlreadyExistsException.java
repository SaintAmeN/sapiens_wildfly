package com.sda.sapiens.wildfly.exception;

import jakarta.ejb.EJBException;

public class ProductAlreadyExistsException extends EJBException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
