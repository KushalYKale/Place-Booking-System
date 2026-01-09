package com.kushal.Place.Booking.System.exception;

public class SlotBlockedException extends BaseDomainException{
    public SlotBlockedException() {
        super(ErrorMessages.SLOT_BLOCKED);
    }
}
