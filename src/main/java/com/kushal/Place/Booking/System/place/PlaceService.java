package com.kushal.Place.Booking.System.place;

import com.kushal.Place.Booking.System.exception.PlaceAlreadyExistException;
import com.kushal.Place.Booking.System.exception.PlaceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlaceService {

    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public PlaceEntity createPlace(String name, int capacity){
        Optional<PlaceEntity> nameCheck = placeRepository.findByName(name);
        if (nameCheck.isPresent()) throw new PlaceAlreadyExistException();

        PlaceEntity placeEntity = new PlaceEntity();
        placeEntity.setName(name);
        placeEntity.setCapacity(capacity);
        placeRepository.save(placeEntity);

        return placeEntity;
    }

    public PlaceEntity getPlaceById(Integer placeId){
        Optional<PlaceEntity> placeIdCheck = placeRepository.findById(placeId);
        if(!placeIdCheck.isPresent()) throw new PlaceNotFoundException();

        return placeIdCheck.get();
    }

    public void validatePlaceExists(Integer placeId){
        Optional<PlaceEntity> placeIdCheck = placeRepository.findById(placeId);
        if(!placeIdCheck.isPresent()) throw new PlaceNotFoundException();
    }

}
