package com.example.calibreapi.controller;

import com.example.calibreapi.dto.SeriesDto;
import com.example.calibreapi.service.SeriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SeriesController {

    private final SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping
    public List<SeriesDto> findAll() {
        return seriesService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesDto> findById(@PathVariable Long id) {
        SeriesDto seriesDto = seriesService.findById(id);
        return seriesDto != null ? ResponseEntity.ok(seriesDto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public SeriesDto save(@RequestBody SeriesDto seriesDto) {
        return seriesService.save(seriesDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        seriesService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
