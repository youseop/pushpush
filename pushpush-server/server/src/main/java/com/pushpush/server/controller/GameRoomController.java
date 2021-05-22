package com.pushpush.server.controller;

import com.pushpush.server.respository.PrivateGameRoomRepository;
import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.vo.PrivateGameRoom;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GameRoomController {

    // 방 생성
    private final PublicGameRoomRepository publicGameRoomRepository;
    private final PrivateGameRoomRepository privateGameRoomRepository;

    private Session session;

    public GameRoomController(PublicGameRoomRepository publicGameRoomRepository, PrivateGameRoomRepository privateGameRoomRepository) {
        this.publicGameRoomRepository = publicGameRoomRepository;
        this.privateGameRoomRepository = privateGameRoomRepository;
    }


    public ModelAndView createRoom() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("game");
        return modelAndView;
    }

    /*
    random 입장
     */
    @GetMapping("game/room-number")
    public int randomEnterPublicRoom() {

    }




    @PostMapping("game/private/room-number")
    public int createPrivateRoom() {
        PrivateGameRoom privateGameRoom = new PrivateGameRoom();
        session.save(privateGameRoom);
        return( (int) privateGameRoomRepository.count() - 1);
    }

}
