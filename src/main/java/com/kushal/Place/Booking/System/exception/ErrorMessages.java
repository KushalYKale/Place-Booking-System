package com.kushal.Place.Booking.System.exception;

public enum ErrorMessages {
    USER_NOT_FOUND("User not found"),
    PLACE_NOT_FOUND("Place not found"),
    BOOKING_NOT_FOUND("Booking Not Found"),
    SLOT_NOT_FOUND("Slot Not Found"),
    INVALID_BOOKING_STATE("Booking Is Invalid Please Try Again"),
    SLOT_NOT_AVAILABLE("The Selected Slot is Not Available Check Again ");


    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
