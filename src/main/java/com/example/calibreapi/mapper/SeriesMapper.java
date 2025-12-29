package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Series;
import com.example.calibreapi.dto.SeriesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeriesMapper {
    SeriesMapper INSTANCE = Mappers.getMapper(SeriesMapper.class);

    SeriesDto toDto(Series series);

    Series toEntity(SeriesDto seriesDto);
}
