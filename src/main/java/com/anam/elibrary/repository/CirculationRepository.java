package com.anam.elibrary.repository;

import com.anam.elibrary.entity.Circulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CirculationRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // untuk simpan data peminjaman buku
    public int saveBookBorrowingData(Circulation circulation) {
        String query = "INSERT INTO circulations (created_at, updated_at, book_id, member_id, request_date, " +
                "return_date, days, status, late_fees) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                circulation.getCreatedAt(), circulation.getUpdatedAt(), circulation.getBookId(),
                circulation.getMemberId(), circulation.getRequestDate(), circulation.getReturnDate(),
                circulation.getDays(), circulation.getStatus(), circulation.getLateFees());
    }

    // untuk simpan data pengembalian buku
    public int saveBookReturnData(Circulation circulation) {
        return 0;
    }

    public List<Circulation> findAll() {
        String query = "SELECT " +
                "c.id, b.book_code, b.title, m.member_code, m.name, c.request_date, c.return_date, c.days, " +
                "c.actual_return_date, c.late_days, c.late_fees, c. total_late_fees, c.status " +
                "FROM circulations c " +
                "JOIN books b ON b.id = c.book_id " +
                "JOIN members m ON m.id = c.member_id";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Circulation(
                        rs.getInt("id"),
                        rs.getString("book_code"),
                        rs.getString("title"),
                        rs.getString("member_code"),
                        rs.getString("name"),
                        rs.getTimestamp("request_date"),
                        rs.getTimestamp("return_date"),
                        rs.getInt("days"),
                        rs.getTimestamp("actual_return_date"),
                        rs.getInt("late_days"),
                        rs.getInt("late_fees"),
                        rs.getInt("total_late_fees"),
                        rs.getString("status")
                )
        );
    }
}
