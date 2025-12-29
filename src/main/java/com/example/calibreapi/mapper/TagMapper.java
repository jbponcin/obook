package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Tag;
import com.example.calibreapi.dto.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagMapper INSTANCE = Mappers.getMapper(TagMapper.class);

    TagDto toDto(Tag tag);

    Tag toEntity(TagDto tagDto);
}
