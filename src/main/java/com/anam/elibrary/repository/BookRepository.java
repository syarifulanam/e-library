package com.anam.elibrary.repository;

import com.anam.elibrary.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Repository adalah tempat kita menulis query
public class BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        String query = "SELECT * FROM books";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("publisher"),
                        rs.getString("year"),
                        rs.getString("book_code"),
                        rs.getTimestamp("created_at"), // kolom di mysql bukan nama paramater java
                        rs.getTimestamp("updated_at")
                )
        );
    }

}