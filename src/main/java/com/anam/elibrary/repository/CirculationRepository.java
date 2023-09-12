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
//        String query = "SELECT * FROM books_circulations";
//        return jdbcTemplate.query(query, (rs, rowNum) -> new Circulation(
//                        rs.getInt("id"),
//                        rs.getString("books_id"),
//                        rs.getString("members_id"),
//                        rs.getTimestamp("start_date"),
//                        rs.getTimestamp("end_date"),
//                        rs.getTimestamp("created_at"),
//                        rs.getTimestamp("updated_at"),
//                        rs.getTimestamp("date_of_return"),
//                        rs.getInt("charge")
//                )
//        );
        return new ArrayList<>();
    }
}
