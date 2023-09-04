package com.anam.elibrary.service;

import com.anam.elibrary.entity.Book;
import com.anam.elibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public int save(Book book) {
        book.setCreatedAt(new Date());
        book.setUpdatedAt(new Date());
        return bookRepository.save(book);
    }

    public int deleteById(int id) {
        return bookRepository.deleteById(id);
    }
}
