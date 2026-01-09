package com.kushal.Place.Booking.System.slot.dto;

import com.kushal.Place.Booking.System.place.PlaceEntity;
import com.kushal.Place.Booking.System.slot.SlotEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SlotResponseDTO {
    private Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean available;
    PlaceEntity placeEntity;

    public SlotResponseDTO(SlotEntity slotEntity){
        this.id = slotEntity.getId();
        this.startTime = slotEntity.getStartTime();
        this.endTime = slotEntity.getEndTime();
        this.available = slotEntity.getAvailable();
        this.placeEntity = slotEntity.getPlaceEntity();
    }

}
