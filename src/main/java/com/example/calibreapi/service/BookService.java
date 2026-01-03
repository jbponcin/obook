package com.example.calibreapi.service;

import com.example.calibreapi.dto.BookDto;
import com.example.calibreapi.mapper.BookMapper;
import com.example.calibreapi.repository.BookProjection;
import com.example.calibreapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public List<BookDto> findAll() {
        return bookRepository.findAll()
            .stream()
            .map(bookMapper::toDto)
            .collect(Collectors.toList());
    }

    public List<BookProjection> findAllProjected() {
        return bookRepository.findAllProjectedBy();
    }

    public BookDto findById(Long id) {
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElse(null);
    }

    public BookDto save(BookDto bookDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookDto)));
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
