package com.kushal.Place.Booking.System.exception;

public class PlaceAlreadyExistException extends BaseDomainException{

    public PlaceAlreadyExistException() {
        super(ErrorMessages.PLACE_ALREADY_EXIST);
    }
}
