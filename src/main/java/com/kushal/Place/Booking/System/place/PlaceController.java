package com.kushal.Place.Booking.System.place;

import com.kushal.Place.Booking.System.place.dto.CreatePlaceRequestDTO;
import com.kushal.Place.Booking.System.place.dto.PlaceResponseDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/places")
public class PlaceController {

    private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public PlaceResponseDTO createPlace(@RequestBody CreatePlaceRequestDTO createPlaceRequestDTO) {
        return new PlaceResponseDTO(placeService.createPlace(createPlaceRequestDTO.getName(), createPlaceRequestDTO.getCapacity()));
    }

    @GetMapping("/{placeId}")
    public PlaceResponseDTO getPlaceById(@PathVariable Integer placeId) {
        return new PlaceResponseDTO(placeService.getPlaceById(placeId));
    }
}
