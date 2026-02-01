package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Tag;
import com.example.calibreapi.dto.TagDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {

    TagDto toDto(Tag tag);

    Tag toEntity(TagDto tagDto);
}
