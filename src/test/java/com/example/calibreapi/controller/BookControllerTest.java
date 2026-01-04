package com.example.calibreapi.controller;

import com.example.calibreapi.domain.*;
import com.example.calibreapi.repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private FormatRepository formatRepository;

    private Book book;

    @BeforeEach
    public void setup() {
        Author author = new Author();
        author.setName("Test Author");
        author.setLink("");
        author = authorRepository.save(author);

        Tag tag = new Tag();
        tag.setName("Test Tag");
        tag = tagRepository.save(tag);

        Series series = new Series();
        series.setName("Test Series");
        series = seriesRepository.save(series);

        Publisher publisher = new Publisher();
        publisher.setName("Test Publisher");
        publisher = publisherRepository.save(publisher);

        book = new Book();
        book.setTitle("Test Book");
        book.setAuthorSort("Author, Test");
        book.setSeriesIndex(1.0);
        book.setPath("test/path");
        book.setFlags(1);
        book.setLastModified(java.time.LocalDateTime.now());
        Set<Author> authors = new HashSet<>();
        authors.add(author);
        book.setAuthors(authors);
        Set<Tag> tags = new HashSet<>();
        tags.add(tag);
        book.setTags(tags);
        book.setSeries(series);
        book.setPublisher(publisher);
        book = bookRepository.save(book);

        Comment comment = new Comment();
        comment.setBook(book);
        comment.setText("Test comment");
        commentRepository.save(comment);

        Format format = new Format();
        format.setBook(book);
        format.setFormat("EPUB");
        format.setName("test.epub");
        format.setUncompressedSize(12345);
        formatRepository.save(format);
    }

    @AfterEach
    public void teardown() {
        bookRepository.deleteAll();
        authorRepository.deleteAll();
        tagRepository.deleteAll();
        seriesRepository.deleteAll();
        publisherRepository.deleteAll();
        commentRepository.deleteAll();
        formatRepository.deleteAll();
    }

    @Test
    public void testFindByIdDefaultView() throws Exception {
        mockMvc.perform(get("/api/books/" + book.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authors").isArray())
                .andExpect(jsonPath("$.tags").isArray())
                .andExpect(jsonPath("$.series").isNumber())
                .andExpect(jsonPath("$.publisher").isNumber());
    }

    @Test
    public void testFindByIdSummaryView() throws Exception {
        mockMvc.perform(get("/api/books/" + book.getId() + "?view=summary"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authors").isArray())
                .andExpect(jsonPath("$.authors[?(@.id != null)]").exists())
                .andExpect(jsonPath("$.authors[?(@.name != null)]").exists())
                .andExpect(jsonPath("$.tags").isArray())
                .andExpect(jsonPath("$.tags[?(@.id != null)]").exists())
                .andExpect(jsonPath("$.tags[?(@.name != null)]").exists())
                .andExpect(jsonPath("$.series.id").isNumber())
                .andExpect(jsonPath("$.series.name").isString())
                .andExpect(jsonPath("$.publisher.id").isNumber())
                .andExpect(jsonPath("$.publisher.name").isString());
    }

    @Test
    public void testFindByIdDetailView() throws Exception {
        mockMvc.perform(get("/api/books/" + book.getId() + "?view=detail"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.authors").isArray())
                .andExpect(jsonPath("$.authors[?(@.id != null)]").exists())
                .andExpect(jsonPath("$.authors[?(@.name != null)]").exists())
                .andExpect(jsonPath("$.tags").isArray())
                .andExpect(jsonPath("$.tags[?(@.id != null)]").exists())
                .andExpect(jsonPath("$.tags[?(@.name != null)]").exists())
                .andExpect(jsonPath("$.series.id").isNumber())
                .andExpect(jsonPath("$.series.name").isString())
                .andExpect(jsonPath("$.publisher.id").isNumber())
                .andExpect(jsonPath("$.publisher.name").isString())
                .andExpect(jsonPath("$.comment.text").isString())
                .andExpect(jsonPath("$.formats").isArray())
                .andExpect(jsonPath("$.formats[?(@.id != null)]").exists())
                .andExpect(jsonPath("$.formats[?(@.format != null)]").exists())
                .andExpect(jsonPath("$.formats[?(@.name != null)]").exists());
    }
}
