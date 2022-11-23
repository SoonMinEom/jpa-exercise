package com.exercise.jpa.service;

import com.exercise.jpa.domain.entity.Author;
import com.exercise.jpa.domain.entity.Book;
import com.exercise.jpa.repository.AuthorRepository;
import com.exercise.jpa.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public ResponseEntity<Book> get(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.get();
        Optional<Author> optionalAuthor = authorRepository.findById((long) book.getAuthorId());
        Author author = optionalAuthor.get();
        book.setAuthorName(author.getName());
        return ResponseEntity.ok().body(book);
    }
}
