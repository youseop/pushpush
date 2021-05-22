package com.pushpush.server.controller;

import com.pushpush.server.respository.PrivateGameRoomRepository;
import com.pushpush.server.respository.PrivateWaitingRoomRepository;
import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.respository.PublicWaitingRoomRepository;

import com.pushpush.server.vo.PrivateGameRoom;
import com.pushpush.server.vo.PrivateWaitingRoom;
import com.pushpush.server.vo.PublicGameRoom;
import com.pushpush.server.vo.PublicWaitingRoom;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameRoomController {

    // 방 생성
     //@Autowired
     private PublicGameRoomRepository publicGameRoomRepository;
     //@Autowired
     private PrivateGameRoomRepository privateGameRoomRepository;
     //@Autowired
     private PublicWaitingRoomRepository publicWaitingRoomRepository;
     //@Autowired
     private PrivateWaitingRoomRepository privateWaitingRoomRepository;

     private Session session;


    /*
    public room random 입장
     */

    @GetMapping("game/room-number")
    public int randomEnterPublicRoom() {
        //JSONObject object = new JSONObject();

        //ModelAndView modelAndView = new ModelAndView();

        if(this.publicGameRoomRepository.count() == 0) {

            PublicGameRoom publicGameRoom = new PublicGameRoom();
            publicGameRoom.setFull(false);
            PublicWaitingRoom publicWaitingRoom = new PublicWaitingRoom();
            publicWaitingRoom.setTotalNumber(4);

            session.save(publicGameRoom);
            session.save(publicWaitingRoom);
        }
        return (int) this.publicGameRoomRepository.count() - 1;
    }

    @PostMapping("game/private/room-number")
    public int createPrivateRoom() {
        PrivateGameRoom privateGameRoom = new PrivateGameRoom();
        PrivateWaitingRoom privateWaitingRoom = new PrivateWaitingRoom();
        session.save(privateGameRoom);
        session.save(privateWaitingRoom);
        return( (int) privateGameRoomRepository.count() - 1);
    }

}
