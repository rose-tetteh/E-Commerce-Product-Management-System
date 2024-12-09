package com.rossie.E_Commerce.Product.Management.System.exception;

public class EntityExistsException extends RuntimeException{
    public EntityExistsException(String message) {
        super(message);
    }
}
