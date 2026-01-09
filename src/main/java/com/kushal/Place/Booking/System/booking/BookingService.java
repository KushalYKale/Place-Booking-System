package com.kushal.Place.Booking.System.booking;

import com.kushal.Place.Booking.System.booking.bookingstatus.BookingStatus;
import com.kushal.Place.Booking.System.dto.BookingResponseDTO;
import com.kushal.Place.Booking.System.exception.*;
import com.kushal.Place.Booking.System.place.PlaceEntity;
import com.kushal.Place.Booking.System.place.PlaceRepository;
import com.kushal.Place.Booking.System.slot.SlotEntity;
import com.kushal.Place.Booking.System.slot.SlotRepository;
import com.kushal.Place.Booking.System.user.UserEntity;
import com.kushal.Place.Booking.System.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final SlotRepository slotRepository;
    private final PlaceRepository placeRepository;

    public BookingService(BookingRepository bookingRepository,
                          UserRepository userRepository,
                          SlotRepository slotRepository, PlaceRepository placeRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.slotRepository = slotRepository;
        this.placeRepository = placeRepository;
    }

    @Transactional
    public BookingEntity createBooking(Integer userId, Integer placeId, Integer slotID){
        Optional<UserEntity> uId =  userRepository.findById(userId);
        Optional<SlotEntity> sId = slotRepository.findById(slotID);
        Optional<PlaceEntity> pId = placeRepository.findById(placeId);
        BookingEntity bookingEntity = new BookingEntity();

        if(uId.isEmpty()) {
            throw new UserNotFoundException();
        } else if (sId.isEmpty()){
            throw new SlotNotFoundException();
        } else if (!pId.isPresent()) {
            throw new PlaceNotFoundException();
        } else if (!sId.get().getAvailable().equals(true)) {
            throw new SlotNotAvailableException();
        } else if (!sId.get().getPlaceEntity().getId().equals(pId.get().getId())){
            throw new InvalidBookingStateException();
        } else{
            bookingEntity.setUserEntity(uId.get());
            bookingEntity.setPlaceEntity(pId.get());
            bookingEntity.setSlotEntity(sId.get());
            bookingEntity.setStatus(BookingStatus.BOOKED);
            SlotEntity slotEntity = bookingEntity.getSlotEntity();
            slotEntity.setAvailable(false);
            slotRepository.save(slotEntity);
            bookingRepository.save(bookingEntity);
        }
        return bookingEntity;
    }

    @Transactional
    public BookingEntity cancelBooking(Integer bookingId) {
        Optional<BookingEntity> bId = bookingRepository.findById(bookingId);
        if(bId.isPresent() && bId.get().getStatus().equals(BookingStatus.BOOKED)){
            bId.get().setStatus(BookingStatus.CANCELLED);
            SlotEntity slotEntity = bId.get().getSlotEntity();
            slotEntity.setAvailable(true);
            slotRepository.save(slotEntity);
            bookingRepository.save(bId.get());
        }else if(bId.isEmpty()){
            throw new BookingNotFoundException();
        } else if (!bId.get().getStatus().equals(BookingStatus.BOOKED)) {
            throw new InvalidBookingStateException();
        }
        return bId.get();
    }

    public BookingEntity getBookingById(Integer bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(BookingNotFoundException::new);
    }

    public List<BookingEntity> getBookingsByUser(Integer userId){
        Optional<UserEntity> uId = userRepository.findById(userId);
        List<BookingEntity> bookingByUserList;
        if (uId.isPresent()) {
            bookingByUserList = bookingRepository.findByUserEntity(uId.get());
        } else {
            throw new UserNotFoundException();
        }
        return bookingByUserList;
    }

    public List<BookingEntity> getBookingsByPlace(Integer placeId){
        Optional<PlaceEntity> pId = placeRepository.findById(placeId);
        List<BookingEntity> bookingByPlaceList;
        if(pId.isPresent()){
            bookingByPlaceList = bookingRepository.findByPlaceEntity(pId.get());
        } else {
            throw new PlaceNotFoundException();
        }
        return  bookingByPlaceList;
    }
}
