package com.exercise.jpa.domain.dto;

import com.exercise.jpa.domain.entity.Book;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;

    public BookResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static BookResponse of(Book book, String name) {
      return BookResponse.builder()
              .id(book.getId())
              .name(book.getName())
              .authorName(name)
              .build();
    }
}
