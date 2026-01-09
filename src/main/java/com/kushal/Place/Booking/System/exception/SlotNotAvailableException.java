package com.kushal.Place.Booking.System.exception;

public class SlotNotAvailableException extends BaseDomainException{
    public SlotNotAvailableException(){
        super(ErrorMessages.SLOT_NOT_AVAILABLE);
    }

}
