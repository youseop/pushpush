package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "chat_message")
public class ChatMessage {
    String author;
    String content;
    String timeStamp;
}
