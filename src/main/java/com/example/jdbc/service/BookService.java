package com.example.jdbc.service;


import com.example.jdbc.model.Book;

public interface BookService {
    Book createBook(Book book);
    Book getBook(Long id);
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);

}
