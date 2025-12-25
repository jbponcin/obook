package com.example.calibreapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String sort;

    @Column(nullable = false)
    private String link;

    // Getters and Setters
}
