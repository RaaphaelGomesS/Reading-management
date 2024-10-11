package com.raphael.ReadingManagement.exception;

import org.springframework.http.HttpStatus;

public class LibraryException extends GenericException {

    public LibraryException(String message, HttpStatus status) {
        super(message, status);
    }
}
