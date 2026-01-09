package com.kushal.Place.Booking.System.place.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreatePlaceRequestDTO {

    @NotNull
    private String name;

    @Positive
    private int capacity;
}
