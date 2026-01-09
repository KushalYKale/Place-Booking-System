package com.kushal.Place.Booking.System.exception;

import lombok.Getter;

import java.util.Map;

@Getter
public class ErrorResponse {
    private final String errorCode;
    private final String message;

    private final int status;
    private final Map<String, String> errors;

    public ErrorResponse(String errorCode, String message, int status) {
        this(errorCode, message, status, null);
    }

    public ErrorResponse(String errorCode, String message, int status, Map<String, String> errors) {
        this.errorCode = errorCode;
        this.message = message;
        this.status = status;
        this.errors = errors;
    }
}
