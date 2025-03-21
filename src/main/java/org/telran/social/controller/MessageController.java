package org.telran.social.controller;

import liquibase.Liquibase;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.MvcNamespaceHandler;
import org.telran.social.dto.MessageDto;
import org.telran.social.service.MessageService;

import java.time.LocalTime;

@RestController
@RequestMapping("api/messages")
@RequiredArgsConstructor

public class MessageController {

    private static final Logger log = LoggerFactory.getLogger(MessageController.class);

    private final MessageService messageService;

    //getAll, getAllByUserId, create, delete
    //Test : messageService, messageController

    @PostMapping
    public void sendMessage(@RequestBody MessageDto messageDto) {
        log.info("Method start at {}", LocalTime.now());
        messageService.sendMessage(messageDto.message(),
                messageDto.from(),
                messageDto.to());
        log.info("Method end at {}", LocalTime.now());

    }

    @GetMapping
    public void getAll() {
        //OFF
        //FATAL
        //ERROR (ERROR, FATAL)
        //WARN  (WARN, ERROR,FATAL)
        //INFO  (INFO, WARN, ERROR,FATAL)  - default
        //DEBUG (DEBUG, INFO, WARN, ERROR,FATAL)
        //TRACE (TRACE, DEBUG, INFO, WARN, ERROR,FATAL)
        log.info("Hello User!");
        log.debug("User user");
        log.error("Errooooooorrrrrrr");

    }
}
