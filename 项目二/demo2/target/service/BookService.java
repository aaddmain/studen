package com.example.demo.service;

import com.example.demo.entity.Book;
import java.util.List;
import java.util.Map;

public interface BookService {
    boolean addBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    List<Book> getBooksByCondition(Map<String, Object> condition);
    boolean updateBook(Book book);
    boolean deleteBook(Long id);
}