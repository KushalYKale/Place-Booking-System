package com.kushal.Place.Booking.System.exception;

public class UserAlreadyExistException extends BaseDomainException {
    public UserAlreadyExistException() {
        super(ErrorMessages.USER_ALREADY_EXIST);
    }
}
