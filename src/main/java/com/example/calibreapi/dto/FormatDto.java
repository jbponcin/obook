package com.example.calibreapi.dto;

import lombok.Data;

@Data
public class FormatDto {
    private Long id;
    private String format;
    private Integer uncompressedSize;
    private String name;
}
