package com.pushpush.server.controller;

import com.pushpush.server.respository.PublicWaitingRoomRepository;
import com.pushpush.server.vo.PublicWaitingRoom;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WaitingRoomController {

    private final PublicWaitingRoomRepository publicWaitingRoomRepository;

    public WaitingRoomController(PublicWaitingRoomRepository publicWaitingRoomRepository) {
        this.publicWaitingRoomRepository = publicWaitingRoomRepository;
    }

    /*
    얻은 방번호를 가지고 대기실 입장.
     */
    @PostMapping("/waiting-room")
    public ModelAndView enterWaitingRoom(@RequestParam int roomNumber) {
        PublicWaitingRoom publicWaitingRoom = publicWaitingRoomRepository.findById(roomNumber).get();

    }


}
