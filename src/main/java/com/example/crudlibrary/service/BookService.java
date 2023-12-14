package com.example.crudlibrary.service;

import com.example.crudlibrary.model.Book;
import com.example.crudlibrary.model.BookDTO;
import com.example.crudlibrary.model.Category;

import java.util.List;

public interface BookService {
    List<BookDTO> findAll();
    BookDTO findById(Long id);

    BookDTO update(Long id, Book book);

    BookDTO create(Book book, Long categoryId);

    void delete(Long id);
}
