package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@Api(tags = "图书管理服务", description = "提供图书的增删改查等全部功能")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @ApiOperation(value = "新增图书", notes = "添加一本新书到图书馆，需要填写完整的图书信息")
    public Result<Boolean> addBook(@RequestBody Book book) {
        boolean result = bookService.addBook(book);
        return Result.success(result);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查询单本图书", notes = "根据图书ID获取详细信息")
    public Result<Book> getBookById(@ApiParam(value = "图书编号", required = true, example = "1") @PathVariable Long id) {
        Book book = bookService.getBookById(id);
        return Result.success(book);
    }

    @GetMapping
    @ApiOperation(value = "获取图书列表", notes = "查询图书馆中所有图书信息")
    public Result<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return Result.success(books);
    }

    @GetMapping("/search")
    @ApiOperation(value = "搜索图书", notes = "支持按书名、作者、分类进行模糊搜索")
    public Result<List<Book>> searchBooks(
            @ApiParam(value = "书名关键词", example = "红楼梦") @RequestParam(required = false) String title,
            @ApiParam(value = "作者名称", example = "曹雪芹") @RequestParam(required = false) String author,
            @ApiParam(value = "图书分类", example = "文学") @RequestParam(required = false) String category) {
        
        Map<String, Object> condition = new HashMap<>();
        condition.put("title", title);
        condition.put("author", author);
        condition.put("category", category);
        
        List<Book> books = bookService.getBooksByCondition(condition);
        return Result.success(books);
    }

    @PutMapping
    @ApiOperation(value = "修改图书信息", notes = "更新图书的基本信息，如书名、作者、库存等")
    public Result<Boolean> updateBook(@RequestBody Book book) {
        boolean result = bookService.updateBook(book);
        return Result.success(result);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除图书", notes = "根据图书ID从系统中移除该图书")
    public Result<Boolean> deleteBook(@ApiParam(value = "图书编号", required = true, example = "1") @PathVariable Long id) {
        boolean result = bookService.deleteBook(id);
        return Result.success(result);
    }
}