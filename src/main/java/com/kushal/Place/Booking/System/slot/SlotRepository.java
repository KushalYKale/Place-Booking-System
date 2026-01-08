package com.kushal.Place.Booking.System.slot;

import com.kushal.Place.Booking.System.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SlotRepository extends JpaRepository<SlotEntity,Integer> {
    boolean existsById(Boolean available);


}
