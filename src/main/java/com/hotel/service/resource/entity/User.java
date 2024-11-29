package com.hotel.service.resource.entity;

import com.hotel.service.resource.validation.Alphabetic;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Alphabetic(message = "Name must contain only alphabetic characters")
    @Size(max = 100, message = "Name must be less than 100 characters")
    private String name;

    public User() {
       super();
    }

    public User(String name, Long id) {
        this.name = name;
        this.id = id;
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
}