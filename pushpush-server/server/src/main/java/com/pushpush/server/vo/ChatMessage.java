package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "chat_message")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int id;
    String author;
    String content;
    String timeStamp;
}
