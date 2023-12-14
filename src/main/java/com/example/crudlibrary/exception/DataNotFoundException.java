package com.example.crudlibrary.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(Long id) {
        super("Data not found with ID: " + id);
    }
}
