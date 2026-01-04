package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Format;
import com.example.calibreapi.domain.Format;
import com.example.calibreapi.dto.FormatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FormatMapper {
    FormatDto toDto(Format format);
    @Mapping(target = "book", ignore = true)
    Format toEntity(FormatDto formatDto);
}
