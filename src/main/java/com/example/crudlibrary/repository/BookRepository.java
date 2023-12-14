package com.example.crudlibrary.repository;

import com.example.crudlibrary.model.Book;
import com.example.crudlibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
}
