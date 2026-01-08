package com.kushal.Place.Booking.System.exception;

public class SlotNotAvailableException extends RuntimeException{
    public SlotNotAvailableException(){
        super(ErrorMessages.SLOT_NOT_AVAILABLE.getMessage());
    }

}
