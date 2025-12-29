package com.example.calibreapi.controller;

import com.example.calibreapi.dto.PublisherDto;
import com.example.calibreapi.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public List<PublisherDto> findAll() {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDto> findById(@PathVariable Long id) {
        PublisherDto publisherDto = publisherService.findById(id);
        return publisherDto != null ? ResponseEntity.ok(publisherDto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PublisherDto save(@RequestBody PublisherDto publisherDto) {
        return publisherService.save(publisherDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        publisherService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
