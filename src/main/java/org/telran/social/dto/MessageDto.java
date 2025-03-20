package org.telran.social.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telran.social.emuns.MessageStatus;
import org.telran.social.entity.Message;

@Getter
@Setter
@NoArgsConstructor
public class MessageDto {

    private Long id;

    private String text;

    private MessageStatus status;

    private Long senderId;

    private Long receiverId;

    public MessageDto(Message message) {
        this.id = message.getId();
        this.text = message.getText();
        this.status = message.getStatus();
        this.senderId = message.getSender().getId();
        this.receiverId = message.getReceiver().getId();
    }
}
