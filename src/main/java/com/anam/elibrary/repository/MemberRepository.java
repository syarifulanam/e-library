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
        return jdbcTemplate.query("SELECT * FROM members", (rs, rowNum) ->
                new Member(
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

    public int save(Member member) {
        String query = "INSERT INTO members (name, member_code, address, phone_number, created_at, updated_at) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                member.getName(), member.getMemberCode(), member.getAddress(), member.getPhoneNumber(), member.getCreatedAt(), member.getUpdatedAt());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM members WHERE id = ?", id);
    }

    public int update(Member member) {
        String query = "UPDATE members SET name = ?, address =?, phone_number = ?, updated_at = ? WHERE id = ?";
        return jdbcTemplate.update(query,
                member.getName(), member.getAddress(), member.getPhoneNumber(), member.getUpdatedAt(), member.getId());
    }

    public Member findById(int id) {
        String query = "SELECT * FROM members WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) ->
                new Member(
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

