package org.telran.social.repository;

import org.telran.social.model.Message;

import java.util.List;

public interface MessageRepository {

    List<Message> getAllByUserId(Long userId);

    Message getById(Long messageId);

    Message create(Message message);

    void deleteById(Long id);
}
