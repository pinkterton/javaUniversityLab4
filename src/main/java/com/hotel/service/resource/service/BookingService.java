package com.hotel.service.resource.service;

import com.hotel.service.resource.entity.Booking;
import com.hotel.service.resource.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Booking not found with ID: " + id));
    }

    public List<Booking> getBookingsByCottageAndDates(Long cottageId, LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByCottageIdAndStartDateBeforeAndEndDateAfter(cottageId, endDate, startDate);
    }

    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
