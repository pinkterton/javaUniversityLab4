package com.hotel.service.resource.controller;

import com.hotel.service.resource.dto.AmenityDTO;
import com.hotel.service.resource.entity.Amenity;
import com.hotel.service.resource.service.AmenityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

    private final AmenityService amenityService;

    public AmenityController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    @GetMapping
    public List<AmenityDTO> getAllAmenities() {
        return amenityService.getAllAmenities()
                .stream()
                .map(amenity -> new AmenityDTO(
                        amenity.getId(),
                        amenity.getName()
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AmenityDTO> getAmenityById(@PathVariable Long id) {
        Amenity amenity = amenityService.getAmenityById(id);
        AmenityDTO amenityDTO = new AmenityDTO(
                amenity.getId(),
                amenity.getName()
        );
        return ResponseEntity.ok(amenityDTO);
    }

    @PostMapping
    public ResponseEntity<AmenityDTO> createAmenity(@RequestBody AmenityDTO amenityDTO) {
        Amenity amenity = new Amenity();
        amenity.setName(amenityDTO.getName());

        Amenity createdAmenity = amenityService.addAmenity(amenity);
        AmenityDTO responseDTO = new AmenityDTO(
                createdAmenity.getId(),
                createdAmenity.getName()
        );

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmenity(@PathVariable Long id) {
        amenityService.deleteAmenity(id);
        return ResponseEntity.noContent().build();
    }
}