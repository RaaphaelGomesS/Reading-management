package com.raphael.ReadingManagement.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {

    private HttpStatus status;

    public GenericException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
