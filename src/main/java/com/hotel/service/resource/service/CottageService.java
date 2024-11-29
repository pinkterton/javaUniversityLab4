package com.hotel.service.resource.service;

import com.hotel.service.resource.entity.Cottage;
import com.hotel.service.resource.repository.CottageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CottageService {
    private final CottageRepository cottageRepository;

    public CottageService(CottageRepository cottageRepository) {
        this.cottageRepository = cottageRepository;
    }

    public List<Cottage> getAllCottages() {
        return cottageRepository.findAll();
    }

    public Cottage getCottageById(Long id) {
        return cottageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cottage not found with ID: " + id));
    }

    public List<Cottage> getCottagesByCategory(String category) {
        return cottageRepository.findByCategory(category);
    }

    public List<Cottage> getCottagesByAmenity(String amenityName) {
        return cottageRepository.findByAmenities_Name(amenityName);
    }


    public Cottage addCottage(Cottage cottage) {
        return cottageRepository.save(cottage);
    }

    public Cottage saveCottage(Cottage cottage) {
        return cottageRepository.save(cottage);
    }

    public void deleteCottage(Long id) {
        cottageRepository.deleteById(id);
    }
}

