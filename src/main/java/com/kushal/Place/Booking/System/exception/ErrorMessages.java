package com.kushal.Place.Booking.System.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorMessages {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"User not found"),
    PLACE_NOT_FOUND(HttpStatus.NOT_FOUND,"Place not found"),
    BOOKING_NOT_FOUND(HttpStatus.NOT_FOUND,"Booking Not Found"),
    SLOT_NOT_FOUND(HttpStatus.NOT_FOUND,"Slot Not Found"),
    INVALID_BOOKING_STATE(HttpStatus.CONFLICT,"Booking Is Invalid Please Try Again"),
    SLOT_NOT_AVAILABLE(HttpStatus.CONFLICT,"The Selected Slot is Not Available Check Again "),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "Invalid request data");


    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final String message;
    ErrorMessages(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
