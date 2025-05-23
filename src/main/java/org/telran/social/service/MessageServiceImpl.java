package org.telran.social.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.telran.social.emuns.MessageStatus;
import org.telran.social.entity.Message;
import org.telran.social.entity.NetworkUser;
import org.telran.social.repository.MessageJpaRepository;

@Service
//@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final NetworkUserService userService;

    private final MessageJpaRepository repository;

    public MessageServiceImpl(NetworkUserService userService, MessageJpaRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

//    private final MessageService messageService;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED )
    public void checkMessage(String message) {

    }

    @Override
    @Transactional()
    public void sendMessage(String message, Long from, Long to) {
        checkMessage(message);
        NetworkUser fromUser = userService.getById(from);
        NetworkUser toUser = userService.getById(to);

        Message fromMessage = Message.builder()
                .sender(fromUser)
                .receiver(toUser)
                .status(MessageStatus.SENT)
                .text(message)
                .build();
        Message entityFrom = repository.save(fromMessage);

        if(from == 8) {
            throw new UnsupportedOperationException();
        }

        Message toMessage = Message.builder()
                .sender(fromUser)
                .receiver(toUser)
                .status(MessageStatus.RECEIVED)
                .text(message)
                .build();
        Message entityTo = repository.save(toMessage);
    }
}
