package com.rossie.E_Commerce.Product.Management.System.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Response handler.
 */
public class ResponseHandler {

    /**
     * Success response entity.
     *
     * @param data       the data
     * @param message    the message
     * @param statusCode the status code
     * @return the response entity
     */
    public static ResponseEntity<Object> success(Object data, String message, HttpStatus statusCode) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", message);
        response.put("success", true);

        return new ResponseEntity<>(response, statusCode);
    }

    /**
     * Error response entity.
     *
     * @param data       the data
     * @param message    the message
     * @param statusCode the status code
     * @return the response entity
     */
    public static ResponseEntity<Object> error(Object data, String message, HttpStatus statusCode) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", message);
        response.put("success", false);

        return new ResponseEntity<>(response, statusCode);
    }
}
