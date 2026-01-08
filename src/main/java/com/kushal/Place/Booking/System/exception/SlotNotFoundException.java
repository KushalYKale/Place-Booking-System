package com.kushal.Place.Booking.System.exception;

public class SlotNotFoundException extends RuntimeException{
    public SlotNotFoundException(){
        super(ErrorMessages.SLOT_NOT_FOUND.getMessage());
    }
}
