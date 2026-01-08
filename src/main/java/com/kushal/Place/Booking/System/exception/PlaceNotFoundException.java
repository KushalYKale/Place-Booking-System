package com.kushal.Place.Booking.System.exception;

public class PlaceNotFoundException extends RuntimeException{
    public PlaceNotFoundException(){
        super(ErrorMessages.PLACE_NOT_FOUND.getMessage());
    }
}
