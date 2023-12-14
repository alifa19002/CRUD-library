package com.example.crudlibrary.service.impl;

import com.example.crudlibrary.exception.DataNotFoundException;
import com.example.crudlibrary.model.Category;
import com.example.crudlibrary.repository.CategoryRepository;
import com.example.crudlibrary.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    @Override
    public Category findById(Long id){
    return categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException(id));
    }
    @Override
    public void delete(Long id) {
        this.findById(id);
        categoryRepository.deleteById(id);
    }
    @Override
    public Category update(Long id, Category category) {
//        category.getId();
        categoryRepository.findById(id).orElseThrow(() -> new DataNotFoundException(id));

//        if (categoryOptional.isEmpty())
//            return new CategoryNotFoundException(id);

        category.setId(id);

        return categoryRepository.save(category);

//        return ResponseEntity.noContent().build();
//        return categoryRepository.save(category);
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }
}