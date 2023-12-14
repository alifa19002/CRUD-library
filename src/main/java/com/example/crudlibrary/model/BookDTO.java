package com.example.crudlibrary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Data
@NoArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private String categoryName;
    private Integer quota;

    public BookDTO(Book book) {
        id = book.getId();
        title = book.getTitle();
        author = book.getAuthor();
        publisher = book.getPublisher();
        categoryName = book.getCategory().getName();
        quota = book.getQuota();
    }
}
