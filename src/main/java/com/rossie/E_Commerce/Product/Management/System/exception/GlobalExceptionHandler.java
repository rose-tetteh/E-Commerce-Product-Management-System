package com.rossie.E_Commerce.Product.Management.System.exception;

import com.rossie.E_Commerce.Product.Management.System.controller.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle entity exists exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(EntityExistsException exception) {
        return ResponseHandler.error(null, exception.getMessage(), HttpStatus.CONFLICT);
    }

    /**
     * Handle entity not found exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseHandler.error(null, exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
