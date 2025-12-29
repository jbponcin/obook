package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Author;
import com.example.calibreapi.dto.AuthorDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto toDto(Author author);

    Author toEntity(AuthorDto authorDto);
}
