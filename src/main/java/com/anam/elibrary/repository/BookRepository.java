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
        return jdbcTemplate.query("SELECT * FROM books", (rs, rowNum) -> new Book(
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

    public int save(Book book) {
        String query = "INSERT INTO books (title, publisher, year, book_code, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                book.getTitle(), book.getPublisher(), book.getYear(), book.getBookCode(), book.getCreatedAt(),
                book.getUpdatedAt());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}
