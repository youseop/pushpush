package com.pushpush.server.controller;

import com.pushpush.server.vo.ChatRoom;
import com.pushpush.server.vo.WaitingRoom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WaitingRoomController {

    @PostMapping("/waiting-room")
    public ModelAndView enterWaitingRoom(@RequestParam int roomNumber) {
        ModelAndView mv = new ModelAndView();
        List<WaitingRoom> new_list = chatRooms.stream().
                filter(chatRoom -> chatRoom.isSameRoomNumber(roomNumber))
                .collect(Collectors.toList());
        if(new_list != null && new_list.size() > 0) {
            mv.addObject("roomNumber", roomNumber);
            mv.setViewName("existing");
        }
        return mv;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("newRoom");
        return modelAndView;
    }
}
