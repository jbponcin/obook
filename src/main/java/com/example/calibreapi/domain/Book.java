package com.example.calibreapi.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String sort;

    private LocalDateTime timestamp;

    private LocalDateTime pubdate;

    @Column(name = "series_index", nullable = false)
    private Double seriesIndex;

    @Column(name = "author_sort")
    private String authorSort;

    private String isbn;

    private String lccn;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private Integer flags;

    private String uuid;

    @Column(name = "has_cover")
    private Boolean hasCover;

    @Column(name = "last_modified", nullable = false)
    private LocalDateTime lastModified;

    @ManyToMany
    @JoinTable(
        name = "books_authors_link",
        joinColumns = @JoinColumn(name = "book"),
        inverseJoinColumns = @JoinColumn(name = "author")
    )
    private Set<Author> authors;

    @ManyToMany
    @JoinTable(
        name = "books_tags_link",
        joinColumns = @JoinColumn(name = "book"),
        inverseJoinColumns = @JoinColumn(name = "tag")
    )
    private Set<Tag> tags;

    @OneToOne
    @JoinTable(
        name = "books_series_link",
        joinColumns = @JoinColumn(name = "book"),
        inverseJoinColumns = @JoinColumn(name = "series")
    )
    private Series series;

    @OneToOne
    @JoinTable(
        name = "books_publishers_link",
        joinColumns = @JoinColumn(name = "book"),
        inverseJoinColumns = @JoinColumn(name = "publisher")
    )
    private Publisher publisher;

    // Getters and Setters
}
