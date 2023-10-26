package com.o1b4.serverquota.exception;

import org.springframework.http.HttpStatus;

public class CustomApiException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public CustomApiException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

