package com.kushal.Place.Booking.System.slot;

import com.kushal.Place.Booking.System.exception.*;
import com.kushal.Place.Booking.System.place.PlaceEntity;
import com.kushal.Place.Booking.System.place.PlaceService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class SlotService {

    private final SlotRepository slotRepository;
    private final PlaceService placeService;

    public SlotService(SlotRepository slotRepository, PlaceService placeService) {
        this.slotRepository = slotRepository;
        this.placeService = placeService;
    }

    public SlotEntity createSlot(
            Integer placeId,
            LocalDateTime startTime,
            LocalDateTime endTime
    ) {
        if (!startTime.isBefore(endTime)) {
            throw new InvalidSlotTimeException();
        }

        PlaceEntity place = placeService.getPlaceById(placeId);

        boolean overlapExists =
                slotRepository.existsOverlappingSlot(
                        place.getId(),
                        startTime,
                        endTime
                );

        if (overlapExists) {
            throw new SlotOverLapException();
        }

        SlotEntity slot = new SlotEntity();
        slot.setStartTime(startTime);
        slot.setEndTime(endTime);
        slot.setAvailable(true);
        slot.setPlaceEntity(place);

        return slotRepository.save(slot);
    }

    public SlotEntity getSlotById(Integer slotId) {
        return slotRepository.findById(slotId)
                .orElseThrow(SlotNotFoundException::new);
    }

    public void validateSlotIsBookable(Integer slotId, Integer placeId) {
        SlotEntity slot = getSlotById(slotId);

        if (!slot.getPlaceEntity().getId().equals(placeId)) {
            throw new SlotPlaceMissmatchException();
        }

        if (!Boolean.TRUE.equals(slot.getAvailable())) {
            throw new SlotBlockedException();
        }
    }

    public void blockSlot(Integer slotId) {
        SlotEntity slot = getSlotById(slotId);
        slot.setAvailable(false);
        slotRepository.save(slot);
    }

    public List<SlotEntity> getSlotsByPlace(Integer placeId) {
        PlaceEntity place = placeService.getPlaceById(placeId);

        return slotRepository.findByPlaceEntity(place);
    }
}

