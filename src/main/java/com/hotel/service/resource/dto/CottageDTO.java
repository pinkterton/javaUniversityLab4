package com.hotel.service.resource.dto;

import java.util.List;

public class CottageDTO {
    private Long id;
    private String cottageId;
    private String category;
    private double basePrice;
    private int maxGuests;
    private List<String> amenities;

    public CottageDTO(Long id, String category, List<String> amenities) {
        this.id = id;
        this.category = category;
        this.amenities = amenities;
    }

    public CottageDTO(Long id, String cottageId, String category, double basePrice, int maxGuests, List<String> amenities) {
        this.id = id;
        this.cottageId = cottageId;
        this.category = category;
        this.basePrice = basePrice;
        this.maxGuests = maxGuests;
        this.amenities = amenities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCottageId() {
        return cottageId;
    }

    public void setCottageId(String cottageId) {
        this.cottageId = cottageId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public int getMaxGuests() {
        return maxGuests;
    }

    public void setMaxGuests(int maxGuests) {
        this.maxGuests = maxGuests;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}
