package com.example.calibreapi.service;

import com.example.calibreapi.dto.PublisherDto;
import com.example.calibreapi.mapper.PublisherMapper;
import com.example.calibreapi.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepository publisherRepository, PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    public List<PublisherDto> findAll() {
        return publisherRepository.findAll()
                .stream()
                .map(publisherMapper::toDto)
                .collect(Collectors.toList());
    }

    public PublisherDto findById(Long id) {
        return publisherRepository.findById(id)
                .map(publisherMapper::toDto)
                .orElse(null);
    }

    public PublisherDto save(PublisherDto publisherDto) {
        return publisherMapper.toDto(publisherRepository.save(publisherMapper.toEntity(publisherDto)));
    }

    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }
}
