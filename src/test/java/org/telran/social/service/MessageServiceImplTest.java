package org.telran.social.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.telran.social.dto.MessageDto;
import org.telran.social.emuns.MessageStatus;
import org.telran.social.entity.Message;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql(scripts = "/dataInit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class MessageServiceImplTest {

    @Autowired
    MessageService messageService;

    @Autowired
    NetworkUserService networkUserService;

    @Test
    void getAll() {
        List<Message> messages = messageService.getAll();
        assertEquals(1, messages.size());
    }

    @Test
    void findAllByUserId() {
        List<MessageDto> allByUserId = messageService.findAllByUserId(1L);
        assertEquals(1, allByUserId.size());
    }

    @Test
    void create() {
        Message message = new Message(null, "test message", null, null, MessageStatus.DRAFT
                , networkUserService.getById(1L), networkUserService.getById(2L));
        MessageDto messageDto = messageService.create(new MessageDto(message));

        assertNotNull(messageDto.getId());
        assertEquals(message.getText(), messageDto.getText());
    }

    @Test
    void deleteMessageById() {
        List<Message> messages = messageService.getAll();
        messageService.deleteMessageById(messages.get(0).getId());
        assertEquals(0, messageService.getAll().size());
    }
}