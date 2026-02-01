package com.example.calibreapi.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "data")
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book", nullable = false)
    private Book book;

    @Column(nullable = false)
    private String format;

    @Column(name = "uncompressed_size", nullable = false)
    private Integer uncompressedSize;

    @Column(nullable = false)
    private String name;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getUncompressedSize() {
        return uncompressedSize;
    }

    public void setUncompressedSize(Integer uncompressedSize) {
        this.uncompressedSize = uncompressedSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
