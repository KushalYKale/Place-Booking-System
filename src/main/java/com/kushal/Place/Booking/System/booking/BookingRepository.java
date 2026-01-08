package com.kushal.Place.Booking.System.booking;

import com.kushal.Place.Booking.System.place.PlaceEntity;
import com.kushal.Place.Booking.System.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    //For The Method getBookingsByUser
    List<BookingEntity> findByUserEntity(UserEntity userEntity);

    //For The Method getBookingsByPlace
    List<BookingEntity> findByPlaceEntity(PlaceEntity placeEntity);
}
