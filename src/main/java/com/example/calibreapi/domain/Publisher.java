package com.example.calibreapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publishers")
public class Publisher {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String sort;

    // Getters and Setters
}
