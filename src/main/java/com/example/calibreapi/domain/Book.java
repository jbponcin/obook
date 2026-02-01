package com.example.calibreapi.domain;

import jakarta.persistence.*;
import jakarta.persistence.Convert;
import com.example.calibreapi.config.LocalDateTimeConverter;
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

    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime timestamp;

    @Convert(converter = LocalDateTimeConverter.class)
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
    @Convert(converter = LocalDateTimeConverter.class)
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

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private Comment comment;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<Format> formats;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getPubdate() {
        return pubdate;
    }

    public void setPubdate(LocalDateTime pubdate) {
        this.pubdate = pubdate;
    }

    public Double getSeriesIndex() {
        return seriesIndex;
    }

    public void setSeriesIndex(Double seriesIndex) {
        this.seriesIndex = seriesIndex;
    }

    public String getAuthorSort() {
        return authorSort;
    }

    public void setAuthorSort(String authorSort) {
        this.authorSort = authorSort;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLccn() {
        return lccn;
    }

    public void setLccn(String lccn) {
        this.lccn = lccn;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getFlags() {
        return flags;
    }

    public void setFlags(Integer flags) {
        this.flags = flags;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getHasCover() {
        return hasCover;
    }

    public void setHasCover(Boolean hasCover) {
        this.hasCover = hasCover;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Set<Format> getFormats() {
        return formats;
    }

    public void setFormats(Set<Format> formats) {
        this.formats = formats;
    }
}
