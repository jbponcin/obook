package com.example.calibreapi.controller;

import com.example.calibreapi.dto.BookDto;
import com.example.calibreapi.dto.BookSummaryDto;
import com.example.calibreapi.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookSummaryDto> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id, @RequestParam(required = false) String view) {
        Object bookDto = bookService.findById(id, view);
        return bookDto != null ? ResponseEntity.ok(bookDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public BookDto save(@RequestBody BookDto bookDto) {
        return bookService.save(bookDto);
    }
}
