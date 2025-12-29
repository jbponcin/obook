package com.example.calibreapi.service;

import com.example.calibreapi.dto.SeriesDto;
import com.example.calibreapi.mapper.SeriesMapper;
import com.example.calibreapi.repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService {

    private final SeriesRepository seriesRepository;
    private final SeriesMapper seriesMapper;

    public SeriesService(SeriesRepository seriesRepository, SeriesMapper seriesMapper) {
        this.seriesRepository = seriesRepository;
        this.seriesMapper = seriesMapper;
    }

    public List<SeriesDto> findAll() {
        return seriesRepository.findAll()
                .stream()
                .map(seriesMapper::toDto)
                .collect(Collectors.toList());
    }

    public SeriesDto findById(Long id) {
        return seriesRepository.findById(id)
                .map(seriesMapper::toDto)
                .orElse(null);
    }

    public SeriesDto save(SeriesDto seriesDto) {
        return seriesMapper.toDto(seriesRepository.save(seriesMapper.toEntity(seriesDto)));
    }

    public void deleteById(Long id) {
        seriesRepository.deleteById(id);
    }
}
