package com.kushal.Place.Booking.System.slot;

import com.kushal.Place.Booking.System.place.PlaceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SlotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "place_id")
    PlaceEntity placeEntity;
}
