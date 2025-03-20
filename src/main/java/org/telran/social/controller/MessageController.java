package org.telran.social.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telran.social.dto.MessageDto;
import org.telran.social.service.MessageService;

@RestController
@RequestMapping("api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    //getAll, getAllByUserId, create, delete
    //Test : messageService, messageController

    @PostMapping
    public void sendMessage(@RequestBody MessageDto messageDto) {
        messageService.sendMessage(messageDto.message(),
                messageDto.from(),
                messageDto.to());
    }
}
