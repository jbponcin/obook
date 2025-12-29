package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Book;
import com.example.calibreapi.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class, TagMapper.class, SeriesMapper.class, PublisherMapper.class})
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toDto(Book book);

    Book toEntity(BookDto bookDto);
}
