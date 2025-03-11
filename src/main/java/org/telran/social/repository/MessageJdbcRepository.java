package org.telran.social.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.telran.social.model.Message;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;

@Repository
public class MessageJdbcRepository implements MessageRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Message> getAllByUserId(Long userId) {
        String sql = "SELECT * FROM messages WHERE sender_id = ?";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(Message.class),
                userId);
    }

    @Override
    public Message getById(Long messageId) {
        String sql = "SELECT * FROM messages WHERE id = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Message.class),
                messageId);
    }

    @Override
    public Message create(Message message) {
        String sql = "INSERT INTO messages (text, sender_id, receiver_id, status)" +
                "values(?,?,?,?)";
        int update = jdbcTemplate.update(sql, message.getText(),
                message.getSenderId(), message.getReceiverId(), message.getStatus().name());
        if (update > 0) {
            String select = "SELECT * FROM messages order by id DESC limit 1";
            return jdbcTemplate.queryForObject(select,
                    new BeanPropertyRowMapper<>(Message.class));
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM messages where id = ?";
        jdbcTemplate.update(sql, id);
    }
}
