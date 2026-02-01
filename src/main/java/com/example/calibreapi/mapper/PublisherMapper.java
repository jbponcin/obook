package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Publisher;
import com.example.calibreapi.dto.PublisherDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toEntity(PublisherDto publisherDto);
}
