package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Publisher;
import com.example.calibreapi.dto.PublisherDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PublisherMapper {
    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);
}
