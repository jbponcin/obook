package com.example.calibreapi.service;

import com.example.calibreapi.dto.AuthorDto;
import com.example.calibreapi.mapper.AuthorMapper;
import com.example.calibreapi.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorService(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    public List<AuthorDto> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    public AuthorDto findById(Long id) {
        return authorRepository.findById(id)
                .map(authorMapper::toDto)
                .orElse(null);
    }

    public AuthorDto save(AuthorDto authorDto) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(authorDto)));
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }
}
