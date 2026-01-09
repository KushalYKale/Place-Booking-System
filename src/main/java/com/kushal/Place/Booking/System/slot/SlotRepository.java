package com.kushal.Place.Booking.System.slot;

import com.kushal.Place.Booking.System.place.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface SlotRepository extends JpaRepository<SlotEntity, Integer> {

    @Query("""
        SELECT COUNT(s) > 0
        FROM SlotEntity s
        WHERE s.placeEntity.id = :placeId
          AND s.startTime < :endTime
          AND s.endTime > :startTime
    """)
    boolean existsOverlappingSlot(
            @Param("placeId") Integer placeId,
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime
    );

    List<SlotEntity> findByPlaceEntity(PlaceEntity placeEntity);


}
