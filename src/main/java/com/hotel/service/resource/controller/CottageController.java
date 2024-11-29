package com.hotel.service.resource.controller;

import com.hotel.service.resource.dto.CottageDTO;
import com.hotel.service.resource.entity.Amenity;
import com.hotel.service.resource.entity.Cottage;
import com.hotel.service.resource.service.CottageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cottages")
public class CottageController {

    private final CottageService cottageService;

    public CottageController(CottageService cottageService) {
        this.cottageService = cottageService;
    }

    @GetMapping
    public List<CottageDTO> getAllCottages() {
        return cottageService.getAllCottages()
                .stream()
                .map(cottage -> new CottageDTO(
                        cottage.getId(),
                        cottage.getCategory().name(),
                        cottage.getAmenities().stream().map(Amenity::getName).collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CottageDTO> getCottageById(@PathVariable Long id) {
        Cottage cottage = cottageService.getCottageById(id);
        CottageDTO cottageDTO = new CottageDTO(
                cottage.getId(),
                cottage.getCategory().name(),
                cottage.getAmenities().stream().map(Amenity::getName).collect(Collectors.toList())
        );
        return ResponseEntity.ok(cottageDTO);
    }

    @PostMapping
    public ResponseEntity<CottageDTO> addCottage(@RequestBody CottageDTO cottageDTO) {
        Cottage cottage = new Cottage();
        cottage.setCategory(cottageDTO.getCategory());
        cottage.setAmenities(cottageDTO.getAmenities().stream()
                .map(Amenity::new)
                .collect(Collectors.toList()));

        Cottage createdCottage = cottageService.addCottage(cottage);
        CottageDTO responseDTO = new CottageDTO(
                createdCottage.getId(),
                createdCottage.getCategory().name(),
                createdCottage.getAmenities().stream().map(Amenity::getName).collect(Collectors.toList())
        );

        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCottage(@PathVariable Long id) {
        cottageService.deleteCottage(id);
        return ResponseEntity.noContent().build();
    }
}
