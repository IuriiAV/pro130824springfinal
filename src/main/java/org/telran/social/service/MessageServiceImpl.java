package org.telran.social.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.telran.social.dto.MessageDto;
import org.telran.social.entity.Message;
import org.telran.social.repository.MessageJpaRepository;
import org.telran.social.repository.NetworkUserJpaRepository;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageJpaRepository repository;

    @Autowired
    NetworkUserJpaRepository userRepository;

    @Override
    public List<Message> getAll() {
        return repository.findAll();
    }

    @Override
    public List<MessageDto> findAllByUserId(Long id) {
        return repository.findAllByUserId(id)
                .stream()
                .map(MessageDto::new)
                .toList();
    }

    @Override
    @Modifying
    @Transactional
    public MessageDto create(MessageDto message) {
        Message messageEntity = new Message();
        messageEntity.setText(message.getText());
        userRepository.findById(message.getSenderId()).ifPresent(sender -> {
            messageEntity.setSender(sender);
        });
        userRepository.findById(message.getReceiverId()).ifPresent(receiver -> {
            messageEntity.setReceiver(receiver);
        });

        return new MessageDto(repository.save(messageEntity));
    }

    @Override
    @Modifying
    @Transactional
    public void deleteMessageById(Long id) {
        repository.deleteById(id);
    }
}
