package com.example.demo.service.impl;

import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean addBook(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public Book getBookById(Long id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookMapper.selectAll();
    }

    @Override
    public List<Book> getBooksByCondition(Map<String, Object> condition) {
        return bookMapper.selectByCondition(condition);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookMapper.update(book) > 0;
    }

    @Override
    public boolean deleteBook(Long id) {
        return bookMapper.deleteById(id) > 0;
    }
}