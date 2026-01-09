package com.kushal.Place.Booking.System.place.dto;

import com.kushal.Place.Booking.System.place.PlaceEntity;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
public class PlaceResponseDTO {
    private Integer id;
    private String name;
    private int capacity;
    private LocalDateTime createdAt;

    public PlaceResponseDTO(PlaceEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.capacity = entity.getCapacity();
        this.createdAt = entity.getCreatedAt();
    }
}
