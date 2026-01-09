package com.kushal.Place.Booking.System.exception;

public class BookingNotFoundException extends BaseDomainException{
    public BookingNotFoundException(){
        super(ErrorMessages.BOOKING_NOT_FOUND);
    }
}
