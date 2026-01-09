package com.kushal.Place.Booking.System.exception;

public class PlaceNotFoundException extends BaseDomainException{
    public PlaceNotFoundException(){
        super(ErrorMessages.PLACE_NOT_FOUND);
    }
}
