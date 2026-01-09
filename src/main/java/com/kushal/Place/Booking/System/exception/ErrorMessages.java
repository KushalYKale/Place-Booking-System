package com.kushal.Place.Booking.System.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorMessages {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"User not found"),
    USER_ALREADY_EXIST(HttpStatus.CONFLICT,"User Already Exist"),

    PLACE_ALREADY_EXIST(HttpStatus.CONFLICT,"Place Already Exist"),
    PLACE_NOT_FOUND(HttpStatus.NOT_FOUND,"Place not found"),

    BOOKING_NOT_FOUND(HttpStatus.NOT_FOUND,"Booking Not Found"),

    INVALID_BOOKING_STATE(HttpStatus.CONFLICT,"Booking Is Invalid Please Try Again"),
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "Invalid request data"),

    //SLOT ENUMS
    SLOT_NOT_AVAILABLE(HttpStatus.CONFLICT,"The Selected Slot is Not Available Check Again "),
    SLOT_NOT_FOUND(HttpStatus.NOT_FOUND,"Slot Not Found"),
    SLOT_OVERLAP( HttpStatus.CONFLICT,"Slot time overlaps with an existing slot"),
    SLOT_BLOCKED( HttpStatus.BAD_REQUEST,"Slot is blocked or unavailable"),
    INVALID_SLOT_TIME(HttpStatus.BAD_REQUEST,"Slot start time must be before end time"),
    SLOT_PLACE_MISMATCH(HttpStatus.BAD_REQUEST,"Slot does not belong to the given place");

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final String message;
    ErrorMessages(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
