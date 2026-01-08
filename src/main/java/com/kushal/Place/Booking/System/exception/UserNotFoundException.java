package com.kushal.Place.Booking.System.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super(ErrorMessages.USER_NOT_FOUND.getMessage());
    }
}
