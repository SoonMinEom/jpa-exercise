package com.exercise.jpa.controller;

import com.exercise.jpa.domain.dto.BookResponse;
import com.exercise.jpa.domain.entity.Book;
import com.exercise.jpa.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<BookResponse>> getBooks(Pageable pageable) {
        return ResponseEntity.ok().body(bookService.findBooks(pageable));
    }
}
