package com.example.calibreapi.repository;

import com.example.calibreapi.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByIdIn(@Param("ids") Collection<Long> ids);
}
