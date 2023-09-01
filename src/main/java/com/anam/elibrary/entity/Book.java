package com.anam.elibrary.entity;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private String publisher;
    private String year;
    private String bookCode;
    private Date createdAt;
    private Date updatedAt;

    public Book() {
    }

    public Book(int id, String title, String publisher, String year, String bookCode, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        this.bookCode = bookCode;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}


