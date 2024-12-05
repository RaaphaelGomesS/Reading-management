package com.raphael.Reading.Management.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ReaderException extends RuntimeException {

    private HttpStatus status;

    private String message;

    public ReaderException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
