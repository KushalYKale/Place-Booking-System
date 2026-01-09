package com.kushal.Place.Booking.System.exception;

public class SlotPlaceMissmatchException extends BaseDomainException{

    public SlotPlaceMissmatchException() {
        super(ErrorMessages.SLOT_PLACE_MISMATCH);
    }
}
