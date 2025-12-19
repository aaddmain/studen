package com.example.demo.entity;

import lombok.Data;
import java.util.Date;

@Data
public class BorrowRecord {
    private Long id;
    private Long userId;
    private Long bookId;
    private Date borrowDate;
    private Date dueDate;
    private Date returnDate;
    private String status;
    private Date createdTime;
    private Date updatedTime;
}