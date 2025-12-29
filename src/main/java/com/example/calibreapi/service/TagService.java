package com.example.calibreapi.service;

import com.example.calibreapi.dto.TagDto;
import com.example.calibreapi.mapper.TagMapper;
import com.example.calibreapi.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagService(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    public List<TagDto> findAll() {
        return tagRepository.findAll()
                .stream()
                .map(tagMapper::toDto)
                .collect(Collectors.toList());
    }

    public TagDto findById(Long id) {
        return tagRepository.findById(id)
                .map(tagMapper::toDto)
                .orElse(null);
    }

    public TagDto save(TagDto tagDto) {
        return tagMapper.toDto(tagRepository.save(tagMapper.toEntity(tagDto)));
    }

    public void deleteById(Long id) {
        tagRepository.deleteById(id);
    }
}
