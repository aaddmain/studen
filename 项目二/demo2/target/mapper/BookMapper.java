package com.example.demo.mapper;

import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {
    int insert(Book book);
    Book selectById(Long id);
    List<Book> selectAll();
    List<Book> selectByCondition(Map<String, Object> condition);
    int update(Book book);
    int deleteById(Long id);
}