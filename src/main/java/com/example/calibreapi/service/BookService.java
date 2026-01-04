package com.example.calibreapi.service;

import com.example.calibreapi.dto.BookDto;
import com.example.calibreapi.dto.BookSummaryDto;
import com.example.calibreapi.mapper.BookMapper;
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

    public List<BookSummaryDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toSummaryDto)
                .collect(Collectors.toList());
    }

    public Object findById(Long id, String view) {
        return bookRepository.findById(id)
                .map(book -> {
                    if (view == null) {
                        return bookMapper.toDefaultDto(book);
                    }
                    switch (view) {
                        case "summary":
                            return bookMapper.toSummaryDto(book);
                        case "detail":
                            return bookMapper.toDetailDto(book);
                        default:
                            return bookMapper.toDefaultDto(book);
                    }
                })
                .orElse(null);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public BookDto save(BookDto bookDto) {
        return bookMapper.toDetailDto(bookRepository.save(bookMapper.toEntity(bookDto)));
    }
}
