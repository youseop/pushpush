package com.pushpush.server.controller;

import com.pushpush.server.respository.PrivateWaitingRoomRepository;
import com.pushpush.server.respository.PublicWaitingRoomRepository;
import com.pushpush.server.vo.PublicWaitingRoom;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Controller
public class WaitingRoomController {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private PublicWaitingRoomRepository publicWaitingRoomRepository;

    @Autowired
    private PrivateWaitingRoomRepository privateWaitingRoomRepository;

    /*
    얻은 방번호를 가지고 대기실 입장.
     */

    @RequestMapping("enter_waiting_room")
    public ModelAndView enter() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("enter_waiting_room");
        return mv;
    }

    @PostMapping("/waiting-room")
    public ModelAndView enterWaitingRoom(@PathVariable Integer roomNumber) {
        Session session = entityManager.unwrap(Session.class);
        ModelAndView modelAndView = new ModelAndView();

        PublicWaitingRoom publicWaitingRoom = publicWaitingRoomRepository.findById(roomNumber).get();
        publicWaitingRoom.setNumOfCurrentUsers(publicWaitingRoom.getNumOfCurrentUsers() + 1);
        modelAndView.setViewName("enter_waiting_room" + roomNumber);
        modelAndView.addObject("roomNumber", roomNumber);
        session.update(publicWaitingRoom);
        return modelAndView;
    }

}
