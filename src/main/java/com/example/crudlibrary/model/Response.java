package com.example.crudlibrary.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Response<T> {
    private String message;
    private T data;
}
