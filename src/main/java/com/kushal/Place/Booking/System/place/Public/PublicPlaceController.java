package com.kushal.Place.Booking.System.place.Public;

import com.kushal.Place.Booking.System.place.PlaceService;
import com.kushal.Place.Booking.System.place.dto.PlaceResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PublicPlaceController {

    private final PlaceService placeService;

    public PublicPlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping
    public List<PlaceResponseDTO> getAllPlaces() {
        return placeService.getAllPlaces()
                .stream()
                .map(PlaceResponseDTO::new)
                .toList();
    }
}