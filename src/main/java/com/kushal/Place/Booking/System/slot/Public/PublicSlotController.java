package com.kushal.Place.Booking.System.slot.Public;

import com.kushal.Place.Booking.System.slot.SlotService;
import com.kushal.Place.Booking.System.slot.dto.SlotResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PublicSlotController {

    private final SlotService slotService;

    public PublicSlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("/{placeId}/slots")
    public List<SlotResponseDTO> getSlotsByPlace(@PathVariable Integer placeId) {
        return slotService.getSlotsByPlace(placeId)
                .stream()
                .map(SlotResponseDTO::new)
                .toList();
    }
}
