package com.example.calibreapi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookSummaryDto {
    private Long id;
    private String title;
    private String sort;
    private LocalDateTime timestamp;
    private LocalDateTime pubdate;
    private Double seriesIndex;
    private String authorSort;
    private String isbn;
    private String lccn;
    private String path;
    private Integer flags;
    private String uuid;
    private Boolean hasCover;
    private LocalDateTime lastModified;
    private Set<AuthorDto> authors;
    private Set<TagDto> tags;
    private SeriesDto series;
    private PublisherDto publisher;
}
