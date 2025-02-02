package com.example.scheduleApp.repository;

import com.example.scheduleApp.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Schedule schedule) {
        String sql = "INSERT INTO schedule (title, author, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, schedule.getTitle(), schedule.getAuthor(), schedule.getPassword());
    }

    public List<Schedule> findAll() {
        String sql = "SELECT id, title, author, updated_at FROM schedule ORDER BY updated_at DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getLong("id"));
            schedule.setTitle(rs.getString("title"));
            schedule.setAuthor(rs.getString("author"));
            schedule.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return schedule;
        });
    }

    public Schedule findById(Long id) {
        String sql = "SELECT id, title, author, updated_at FROM schedule WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            Schedule schedule = new Schedule();
            schedule.setId(rs.getLong("id"));
            schedule.setTitle(rs.getString("title"));
            schedule.setAuthor(rs.getString("author"));
            schedule.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());
            return schedule;
        }, id);
    }
}
