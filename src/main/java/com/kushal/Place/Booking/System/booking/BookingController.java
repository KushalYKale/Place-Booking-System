package com.kushal.Place.Booking.System.booking;

import com.kushal.Place.Booking.System.booking.dto.BookingResponseDTO;
import com.kushal.Place.Booking.System.booking.dto.CreateBookingRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/bookings")
    public BookingResponseDTO createBooking(@RequestBody @Valid CreateBookingRequestDTO createBookingRequestDTO){
        return new BookingResponseDTO(bookingService.createBooking(createBookingRequestDTO.getUserId(),
                createBookingRequestDTO.getPlaceId(), createBookingRequestDTO.getSlotId()));
    }

    @DeleteMapping("/bookings/{bookingId}")
    public BookingResponseDTO cancelBooking(@PathVariable Integer bookingId){
        return new BookingResponseDTO(bookingService.cancelBooking(bookingId));
    }

    @GetMapping("/bookings/{bookingId}")
    public BookingResponseDTO getBookingById(@PathVariable Integer bookingId){
        return new BookingResponseDTO(bookingService.getBookingById(bookingId));
    }

    @GetMapping("/users/{userId}/bookings")
    public List<BookingResponseDTO> getBookingsByUser(@PathVariable Integer userId){
        return bookingService.getBookingsByUser(userId)
                .stream()
                .map(BookingResponseDTO::new)
                .toList();
    }

    @GetMapping("/places/{placeId}/bookings")
    public List<BookingResponseDTO> getBookingsByPlace(@PathVariable Integer placeId){
        return bookingService.getBookingsByPlace(placeId)
                .stream()
                .map(BookingResponseDTO::new)
                .toList();
    }

}
