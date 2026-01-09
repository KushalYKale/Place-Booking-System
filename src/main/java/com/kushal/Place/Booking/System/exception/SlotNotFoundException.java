package com.kushal.Place.Booking.System.exception;

public class SlotNotFoundException extends BaseDomainException{
    public SlotNotFoundException(){
        super(ErrorMessages.SLOT_NOT_FOUND);
    }
}
