package com.hotel.service.resource.service;

import com.hotel.service.resource.entity.Amenity;
import com.hotel.service.resource.repository.AmenityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityService {
    private final AmenityRepository amenityRepository;

    public AmenityService(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    public Amenity getAmenityById(Long id) {
        return amenityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Amenity not found with ID: " + id));
    }

    public List<Amenity> getAmenitiesByName(String name) {
        return amenityRepository.findByName(name);
    }

    public Amenity addAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    public Amenity saveAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    public void deleteAmenity(Long id) {
        amenityRepository.deleteById(id);
    }
}

