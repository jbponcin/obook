package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Author;
import com.example.calibreapi.dto.AuthorDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorDto toDto(Author author);

    Author toEntity(AuthorDto authorDto);
}
