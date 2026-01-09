package com.kushal.Place.Booking.System.place;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity ,Integer> {
    Optional<PlaceEntity> findByName(String name);
}
