package com.anam.elibrary.repository;

import com.anam.elibrary.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                )
        );
    }

    public int save(User user) {
        String query = "INSERT INTO users (name, username, password, role, created_at, updated_at) " +
                "VALUE (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(query,
                user.getName(), user.getUsername(), user.getPassword(), user.getRole(), user.getCreatedAt(), user.getUpdatedAt());
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public int update(User user) {
        String query = "UPDATE users SET name = ?, username = ?, password = ?, role = ?, updated_at = ? WHERE id = ?";
        return jdbcTemplate.update(query,
                user.getName(), user.getUsername(), user.getPassword(), user.getRole(), user.getUpdatedAt(), user.getId());
    }

    public User findById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getTimestamp("created_at"),
                        rs.getTimestamp("updated_at")
                )
        );
    }
}



