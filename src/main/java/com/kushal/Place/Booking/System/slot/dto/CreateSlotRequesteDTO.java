package com.kushal.Place.Booking.System.slot.dto;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Data
public class CreateSlotRequesteDTO {

    Integer placeId;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
