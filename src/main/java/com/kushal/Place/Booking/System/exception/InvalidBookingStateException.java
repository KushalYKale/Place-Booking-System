package com.kushal.Place.Booking.System.exception;

public class InvalidBookingStateException extends RuntimeException{
    public InvalidBookingStateException(){
        super(ErrorMessages.INVALID_BOOKING_STATE.getMessage());
    }
}
