package com.example.calibreapi.mapper;

import com.example.calibreapi.domain.Comment;
import com.example.calibreapi.domain.Comment;
import com.example.calibreapi.dto.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto toDto(Comment comment);
    @Mapping(target = "book", ignore = true)
    Comment toEntity(CommentDto commentDto);
}
