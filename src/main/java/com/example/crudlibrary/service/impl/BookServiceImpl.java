package com.example.crudlibrary.service.impl;

import com.example.crudlibrary.exception.DataNotFoundException;
import com.example.crudlibrary.model.Book;
import com.example.crudlibrary.model.BookDTO;
import com.example.crudlibrary.model.Category;
import com.example.crudlibrary.repository.BookRepository;
import com.example.crudlibrary.repository.CategoryRepository;
import com.example.crudlibrary.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<BookDTO> findAll(){

        List<Book> list = bookRepository.findAll();
        return list.stream().map(BookDTO::new).collect(Collectors.toList());
    }
    @Override
    public BookDTO findById(Long id){
        return new BookDTO(bookRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(id)));
    }
    @Override
    public void delete(Long id) {
        this.findById(id);
        bookRepository.deleteById(id);
    }
    @Override
    public BookDTO update(Long id, Book book) {
        bookRepository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
        book.setId(id);
        Long categoryId = book.getCategId();
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new DataNotFoundException(categoryId));
        book.setCategory(category);
        var bookSaved = bookRepository.save(book);
        return new BookDTO(bookSaved);
    }

    @Override
    public BookDTO create(Book book, Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new DataNotFoundException(categoryId));
        book.setCategory(category);
        var bookSaved = bookRepository.save(book);
        return new BookDTO(bookSaved);
    }
}
