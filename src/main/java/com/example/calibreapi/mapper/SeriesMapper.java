package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Series;
import com.example.calibreapi.dto.SeriesDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeriesMapper {

    SeriesDto toDto(Series series);

    Series toEntity(SeriesDto seriesDto);
}
