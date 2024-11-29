package com.hotel.service.resource.entity;

import jakarta.persistence.*;

@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double cost;
    private int additionalCapacity;

    public Amenity() {
        super();
    }

    public Amenity(String name) {
        this.name = name;
    }

    public Amenity(Long id, String name, double cost, int additionalCapacity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.additionalCapacity = additionalCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getAdditionalCapacity() {
        return additionalCapacity;
    }

    public void setAdditionalCapacity(int additionalCapacity) {
        this.additionalCapacity = additionalCapacity;
    }
}
