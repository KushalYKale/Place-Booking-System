package com.kushal.Place.Booking.System.exception;

import lombok.Getter;

@Getter
public abstract class BaseDomainException extends RuntimeException {

    private final ErrorMessages errorMessages;

    protected BaseDomainException(ErrorMessages errorMessages) {
        super(errorMessages.getMessage());
        this.errorMessages = errorMessages;
    }

}
