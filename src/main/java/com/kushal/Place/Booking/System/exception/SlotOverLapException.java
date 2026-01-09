package com.kushal.Place.Booking.System.exception;

public class SlotOverLapException extends BaseDomainException{

    public SlotOverLapException() {
        super(ErrorMessages.SLOT_OVERLAP);
    }
}
