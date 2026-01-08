package com.kushal.Place.Booking.System.booking;

import com.kushal.Place.Booking.System.booking.bookingstatus.BookingStatus;
import com.kushal.Place.Booking.System.place.PlaceEntity;
import com.kushal.Place.Booking.System.slot.SlotEntity;
import com.kushal.Place.Booking.System.user.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    @NotNull
    SlotEntity slotEntity;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "place_id")
    @NotNull
    PlaceEntity placeEntity;

}
