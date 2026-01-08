package com.kushal.Place.Booking.System.booking.bookingstatus;

public enum BookingStatus {
    BOOKED("Slot is Booked"),
    CANCELLED("Slot Booking is Cancelled");

    private final String message;

    BookingStatus(String message) {
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }

}
