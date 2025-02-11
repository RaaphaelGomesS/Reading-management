package com.raphael.Reading.Management.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BookException extends RuntimeException {
    private HttpStatus status;

    private String message;

    public BookException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
