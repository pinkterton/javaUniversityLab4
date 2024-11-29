package com.hotel.service.resource.controller;

import com.hotel.service.resource.dto.BookingDTO;
import com.hotel.service.resource.entity.Booking;
import com.hotel.service.resource.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDTO> getAllBookings() {
        return bookingService.getAllBookings()
                .stream()
                .map(booking -> new BookingDTO(
                        booking.getId(),
                        booking.getUser().getId(),
                        booking.getCottage().getId(),
                        booking.getStartDate(),
                        booking.getEndDate()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id);
        BookingDTO bookingDTO = new BookingDTO(
                booking.getId(),
                booking.getUser().getId(),
                booking.getCottage().getId(),
                booking.getStartDate(),
                booking.getEndDate()
        );
        return ResponseEntity.ok(bookingDTO);
    }

    @GetMapping("/user/{userId}")
    public List<BookingDTO> getBookingsByUserId(@PathVariable Long userId) {
        return bookingService.getBookingsByUserId(userId)
                .stream()
                .map(booking -> new BookingDTO(
                        booking.getId(),
                        booking.getUser().getId(),
                        booking.getCottage().getId(),
                        booking.getStartDate(),
                        booking.getEndDate()
                ))
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndDate(bookingDTO.getEndDate());

        Booking createdBooking = bookingService.createBooking(booking);
        BookingDTO responseDTO = new BookingDTO(
                createdBooking.getId(),
                createdBooking.getUser().getId(),
                createdBooking.getCottage().getId(),
                createdBooking.getStartDate(),
                createdBooking.getEndDate()
        );

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}