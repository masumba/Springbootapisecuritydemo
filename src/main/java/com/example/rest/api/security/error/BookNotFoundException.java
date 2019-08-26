package com.example.rest.api.security.error;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book with id: ["+id+"] not found");
    }
}
