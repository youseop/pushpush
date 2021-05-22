package com.pushpush.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameRoomController {
    @RequestMapping(value = "/game" , headers = "Connection!=Upgrade")
    // 방 생성
    public ModelAndView newRoom() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        return modelAndView;
    }
}
