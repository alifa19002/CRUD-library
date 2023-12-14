package com.example.crudlibrary.repository;

import com.example.crudlibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{
//    List<Category> findByPublished(boolean published);
//
//    List<Category> findByTitleContaining(String title);
}
