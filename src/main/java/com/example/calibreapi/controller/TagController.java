package com.example.calibreapi.controller;

import com.example.calibreapi.dto.TagDto;
import com.example.calibreapi.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public List<TagDto> findAll() {
        return tagService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDto> findById(@PathVariable Long id) {
        TagDto tagDto = tagService.findById(id);
        return tagDto != null ? ResponseEntity.ok(tagDto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TagDto save(@RequestBody TagDto tagDto) {
        return tagService.save(tagDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        tagService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
