package org.telran.social.model;

import lombok.*;
import org.telran.social.emuns.MessageStatus;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Message {

    private Long id;

    private String text;

    //В Java: senderId, в базе данных: sender_id
    private Long senderId;

    private Long receiverId;

    private MessageStatus status;

    public Message() {
        //
    }
}
