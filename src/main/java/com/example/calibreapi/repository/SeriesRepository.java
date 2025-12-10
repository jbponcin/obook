package com.example.calibreapi.repository;

import com.example.calibreapi.domain.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "series", path = "series")
public interface SeriesRepository extends JpaRepository<Series, Long> {
}
