package com.hotel.service.resource.dto;

import java.time.LocalDate;

public class BookingDTO {
    private Long id;
    private Long userId;
    private Long cottageId;
    private LocalDate startDate;
    private LocalDate endDate;


    public BookingDTO(Long id, Long userId, Long cottageId, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.userId = userId;
        this.cottageId = cottageId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCottageId() {
        return cottageId;
    }

    public void setCottageId(Long cottageId) {
        this.cottageId = cottageId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
