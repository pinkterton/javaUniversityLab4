package com.hotel.service.resource.dto;

public class AmenityDTO {
    private Long id;
    private String name;
    private double cost;
    private int additionalCapacity;

    public AmenityDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
