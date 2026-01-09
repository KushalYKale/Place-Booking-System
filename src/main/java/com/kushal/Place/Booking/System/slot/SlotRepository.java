package com.kushal.Place.Booking.System.slot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

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
}
