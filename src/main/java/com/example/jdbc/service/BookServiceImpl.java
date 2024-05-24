package com.example.jdbc.service;

import com.example.jdbc.model.Book;
import com.example.jdbc.model.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;
    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book updateBook(Long id, Book book) {
        if (getBook(id)!=null){
            Book oldBook = getBook(id);
            oldBook.setAuthor(book.getAuthor());
            oldBook.setTitle(book.getTitle());
            oldBook.setPublicationYear(book.getPublicationYear());
            return bookRepository.save(oldBook);
        }else {
            return null;
        }
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
