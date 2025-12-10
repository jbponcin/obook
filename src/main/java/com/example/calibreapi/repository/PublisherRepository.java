package com.example.calibreapi.repository;

import com.example.calibreapi.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "publishers", path = "publishers")
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
