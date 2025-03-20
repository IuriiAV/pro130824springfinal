package org.telran.social.service;


import org.springframework.transaction.annotation.Transactional;

public interface MessageService {

    //@Transactional
    void sendMessage(String message, Long from, Long to);

    void checkMessage(String message);
}
