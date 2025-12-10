package com.example.calibreapi.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    @Id
    private Long id;

    private String title;

    private String sort;

    private LocalDateTime timestamp;

    private LocalDateTime pubdate;

    @Column(name = "series_index")
    private Double seriesIndex;

    @Column(name = "author_sort")
    private String authorSort;

    private String isbn;

    private String lccn;

    private String path;

    private Integer flags;

    private String uuid;

    @Column(name = "has_cover")
    private Boolean hasCover;

    @Column(name = "last_modified")
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
