package org.telran.social.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telran.social.dto.MessageDto;
import org.telran.social.service.MessageService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    //getAll, getAllByUserId, create, delete
    //Test : messageService, messageController

    @Autowired
    private MessageService service;

    @GetMapping
    public List<MessageDto> getAll() {
        return service.getAll()
                .stream()
                .map(MessageDto::new)
                .toList();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Map<String, Object>> getAllByUserId(@PathVariable Long id) {
        List<MessageDto> messages = service.findAllByUserId(id);

        if (messages.isEmpty()) {
            throw new EntityNotFoundException();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of(
                        "status", HttpStatus.OK.value(),
                        "data", messages
                ));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageDto create(@RequestBody MessageDto message) {
        return service.create(message);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteMessageById(id);
    }
}
