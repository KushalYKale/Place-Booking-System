package com.kushal.Place.Booking.System.exception;

public class InvalidSlotTimeException extends BaseDomainException{
    public InvalidSlotTimeException() {
        super(ErrorMessages.INVALID_SLOT_TIME);
    }
}
