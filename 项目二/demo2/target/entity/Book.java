package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
@ApiModel(value = "图书信息", description = "图书的详细信息")
public class Book {
    @ApiModelProperty(value = "图书编号", example = "1")
    private Long id;
    
    @ApiModelProperty(value = "书名", example = "红楼梦", required = true)
    private String title;
    
    @ApiModelProperty(value = "作者", example = "曹雪芹", required = true)
    private String author;
    
    @ApiModelProperty(value = "ISBN号", example = "978-7-02-000220-9", required = true)
    private String isbn;
    
    @ApiModelProperty(value = "出版社", example = "人民文学出版社", required = true)
    private String publisher;
    
    @ApiModelProperty(value = "出版日期", example = "2020-01-01")
    private Date publishDate;
    
    @ApiModelProperty(value = "图书分类", example = "文学", required = true)
    private String category;
    
    @ApiModelProperty(value = "总库存数量", example = "10")
    private Integer totalCopies;
    
    @ApiModelProperty(value = "可借数量", example = "8")
    private Integer availableCopies;
    
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createdTime;
    
    @ApiModelProperty(value = "更新时间", hidden = true)
    private Date updatedTime;
}