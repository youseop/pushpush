package com.pushpush.server.controller;

import com.pushpush.server.respository.PrivateGameRoomRepository;
import com.pushpush.server.respository.PrivateWaitingRoomRepository;
import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.respository.PublicWaitingRoomRepository;
import com.pushpush.server.vo.PrivateGameRoom;
import com.pushpush.server.vo.PrivateWaitingRoom;
import com.pushpush.server.vo.PublicGameRoom;
import com.pushpush.server.vo.PublicWaitingRoom;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GameRoomController {

    // 방 생성
    private final PublicGameRoomRepository publicGameRoomRepository;
    private final PrivateGameRoomRepository privateGameRoomRepository;
    private final PublicWaitingRoomRepository publicWaitingRoomRepository;
    private final PrivateWaitingRoomRepository privateWaitingRoomRepository;

    private Session session;

    public GameRoomController(PublicGameRoomRepository publicGameRoomRepository, PrivateGameRoomRepository privateGameRoomRepository, PublicWaitingRoomRepository publicWaitingRoomRepository, PrivateWaitingRoomRepository privateWaitingRoomRepository) {
        this.publicGameRoomRepository = publicGameRoomRepository;
        this.privateGameRoomRepository = privateGameRoomRepository;
        this.publicWaitingRoomRepository = publicWaitingRoomRepository;
        this.privateWaitingRoomRepository = privateWaitingRoomRepository;
    }

    public ModelAndView createRoom() {

    }

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
        return  (int) this.publicGameRoomRepository.count() - 1;
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
