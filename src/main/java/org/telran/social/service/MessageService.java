package org.telran.social.service;

import org.telran.social.dto.MessageDto;
import org.telran.social.entity.Message;

import java.util.List;

public interface MessageService {

    //getAll, getAllByUserId, create, delete

    List<Message> getAll();

    List<MessageDto> findAllByUserId(Long userId);

    MessageDto create(MessageDto message);

    void deleteMessageById(Long id);
}
