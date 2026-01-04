package com.example.calibreapi.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class BookDefaultDto {
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
    private Set<Long> authors;
    private Set<Long> tags;
    private Long series;
    private Long publisher;
}
