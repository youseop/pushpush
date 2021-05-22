package com.pushpush.server.controller;

import com.pushpush.server.vo.ChatRoom;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ChattingController {

    //@MessageMapping("/receive")
    //@SendTo("send")
    /*@RequestMapping("/send")
    public @ResponseBody
    List<ChatRoom> createRoom() {
        ChatRoom chatRoom = new ChatRoom();
        chatRooms.add(chatRoom);
        return chatRooms;
    }*/
}
