package com.kushal.Place.Booking.System.exception;

public class UserNotFoundException extends BaseDomainException{
    public UserNotFoundException(){
        super(ErrorMessages.USER_NOT_FOUND);
    }
}
