package com.kushal.Place.Booking.System.slot;

import com.kushal.Place.Booking.System.slot.dto.CreateSlotRequesteDTO;
import com.kushal.Place.Booking.System.slot.dto.SlotResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/admin/slots")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public SlotResponseDTO createSlot(@RequestBody CreateSlotRequesteDTO createSlotRequesteDTO) {
        return new SlotResponseDTO(slotService.createSlot(createSlotRequesteDTO.getPlaceId(),createSlotRequesteDTO.getStartTime(), createSlotRequesteDTO.getEndTime()));
    }

    @GetMapping("/{slotId}")
    public SlotResponseDTO getSlotById(@PathVariable Integer slotId) {
        return new SlotResponseDTO(slotService.getSlotById(slotId));
    }

    @PatchMapping("/{slotId}/block")
    public void blockSlot(@PathVariable Integer slotId) {
        slotService.blockSlot(slotId);
    }
}
