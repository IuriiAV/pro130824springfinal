package org.telran.social.entity;

import jakarta.persistence.*;
import lombok.*;
import org.telran.social.emuns.MessageStatus;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {

    @Id // указывает что это поле первичный ключ
    @GeneratedValue(strategy = GenerationType.IDENTITY) // задает автогенерацию значения поля
    private Long id;

    private String text;

    //JDBC
    //В Java: senderId, в базе данных: sender_id
    @Column(name = "s_id")
    private Long senderId;
    //JDBC
    @Column(name = "r_id")
    private Long receiverId;

    private MessageStatus status;

    @ManyToOne
    private NetworkUser sender; //sender_id

    @ManyToOne
    private NetworkUser receiver; //receiver_id



    public Message() {
        //
    }
}
