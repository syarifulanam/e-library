package com.anam.elibrary.repository;

import com.anam.elibrary.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Member> findAll() {
        String query = "SELECT * FROM members";
        return jdbcTemplate.query(query, (rs, rowNum) -> new Member(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("member_code"),
                        rs.getString("address"),
                        rs.getString("phone_number"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                )
        );
    }
}

