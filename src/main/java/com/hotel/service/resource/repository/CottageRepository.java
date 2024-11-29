package com.hotel.service.resource.repository;

import com.hotel.service.resource.entity.Cottage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CottageRepository extends JpaRepository<Cottage, Long> {
    List<Cottage> findByCategory(String category);

    List<Cottage> findByAmenities_Name(String amenityName);
}
