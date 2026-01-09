package com.kushal.Place.Booking.System.booking.dto;

import com.kushal.Place.Booking.System.booking.BookingEntity;
import com.kushal.Place.Booking.System.booking.bookingstatus.BookingStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class BookingResponseDTO {

    private Integer bookingId;

    private Integer userId;

    private Integer placeId;

    private Integer slotId;

    private BookingStatus status;

    private LocalDateTime createdAt;

    public BookingResponseDTO(BookingEntity booking) {
        this.bookingId = booking.getId();
        this.userId = booking.getUserEntity().getId();
        this.placeId = booking.getPlaceEntity().getId();
        this.slotId = booking.getSlotEntity().getId();
        this.status = booking.getStatus();
        this.createdAt = booking.getCreatedAt();
    }
}
