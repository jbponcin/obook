package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Book;
import com.example.calibreapi.domain.Publisher;
import com.example.calibreapi.domain.Series;
import com.example.calibreapi.dto.BookDto;
import com.example.calibreapi.dto.PublisherDto;
import com.example.calibreapi.dto.SeriesDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import org.mapstruct.Mapping;

import com.example.calibreapi.dto.BookDefaultDto;
import com.example.calibreapi.dto.BookSummaryDto;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class, TagMapper.class, SeriesMapper.class, PublisherMapper.class, CommentMapper.class, FormatMapper.class})
public interface BookMapper {

    @Mapping(target = "authors", expression = "java(book.getAuthors().stream().map(author -> author.getId()).collect(java.util.stream.Collectors.toSet()))")
    @Mapping(target = "tags", expression = "java(book.getTags().stream().map(tag -> tag.getId()).collect(java.util.stream.Collectors.toSet()))")
    @Mapping(target = "series", expression = "java(book.getSeries() != null ? book.getSeries().getId() : null)")
    @Mapping(target = "publisher", expression = "java(book.getPublisher() != null ? book.getPublisher().getId() : null)")
    BookDefaultDto toDefaultDto(Book book);

    BookSummaryDto toSummaryDto(Book book);

    BookDto toDetailDto(Book book);

    Book toEntity(BookDto bookDto);
}
