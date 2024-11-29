package com.hotel.service.resource.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Cottage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cottageId;

    @Enumerated(EnumType.STRING)
    private Category category;

    private double basePrice;
    private int maxGuests;

    @OneToMany(mappedBy = "cottage", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Booking> bookings = new ArrayList<>();

    @ManyToMany
    private List<Amenity> amenities = new ArrayList<>();

    public Cottage() {
        super();
    }

    public Cottage(Long id, String cottageId, Category category, double basePrice, int maxGuests, List<Booking> bookings, List<Amenity> amenities) {
        this.id = id;
        this.cottageId = cottageId;
        this.category = category;
        this.basePrice = basePrice;
        this.maxGuests = maxGuests;
        this.bookings = bookings;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setCategory(String category) {
        try {
            this.category = Category.valueOf(category.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
        booking.setCottage(this); // Синхронізація двостороннього зв’язку
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
        for (Booking booking : bookings) {
            booking.setCottage(this); // Синхронізація
        }
    }

    public List<Amenity> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<Amenity> amenities) {
        this.amenities = amenities;
    }
}
