package com.kushal.Place.Booking.System.booking.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookingRequestDTO {
    @NotNull
    Integer userId;

    @NotNull
    Integer placeId;

    @NotNull
    Integer slotId;
}
