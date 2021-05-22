package com.pushpush.server.controller;

import com.pushpush.server.vo.ChatRoom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChatRoomController {
    List<ChatRoom> chatRooms = new ArrayList<>();

    @RequestMapping(value = "/chat" , headers = "Connection!=Upgrade")
    // 방 생성
    public ModelAndView newRoom() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chat");
        return modelAndView;
    }

    @RequestMapping(value = "/location" , headers = "Connection!=Upgrade")
    // 방 생성
    public ModelAndView newLocation() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("chat");
        return modelAndView;
    }

    @RequestMapping("/existing")
    // 기존 방
    public ModelAndView existing() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("existing");
        return mv;
    }

    /**
     * 방 정보가져오기
     * @param params
     * @return
     */
    @RequestMapping("/getRoom")
    public @ResponseBody List<ChatRoom> getRoom(@RequestParam HashMap<Object, Object> params){
        return chatRooms;
    }

    /**
     * 게임방
     * @return
     */
    @RequestMapping("/game/chatting")
    public ModelAndView moveToRoom(@RequestParam int roomNumber) {
        ModelAndView mv = new ModelAndView();

        List<ChatRoom> new_list = chatRooms.stream().
                                           filter(chatRoom -> chatRoom.isSameRoomNumber(roomNumber))
                                           .collect(Collectors.toList());
        if(new_list != null && new_list.size() > 0) {
            mv.addObject("roomNumber", roomNumber);
            mv.setViewName("existing");
        }
        return mv;
    }


}
