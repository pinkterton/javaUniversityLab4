package com.hotel.service.resource.repository;

import com.hotel.service.resource.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByCottageIdAndStartDateBeforeAndEndDateAfter(
            Long cottageId, LocalDate endDate, LocalDate startDate);

    List<Booking> findByUserId(Long userId);
}