package com.pushpush.server.controller;



import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.service.PublicGameRoomService;
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


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
@RequiredArgsConstructor
public class GameRoomController {

    // 방 생성

    //@Autowired

//    @Autowired
//    private final PublicGameRoomService publicGameRoomService;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private final PublicGameRoomRepository publicGameRoomRepository;
    /*
    public room random 입장
     */
    @GetMapping("game/room-number")
    public int randomEnterPublicRoom() {
        //JSONObject object = new JSONObject();
        //ModelAndView modelAndView = new ModelAndView

        Session session = entityManager.unwrap(Session.class);

        if(this.publicGameRoomRepository.count() == 0) {

            PublicGameRoom publicGameRoom = new PublicGameRoom();
            PublicWaitingRoom publicWaitingRoom = new PublicWaitingRoom();
            //publicGameRoomRepository.save(publicGameRoom);
            session.save(publicGameRoom);
            session.save(publicWaitingRoom);
        }

        return (int) (this.publicGameRoomRepository.count() - 1);
    }

//    @PostMapping("game/private/room-number")
//    public int createPrivateRoom() {
//        PrivateGameRoom privateGameRoom = new PrivateGameRoom();
//        PrivateWaitingRoom privateWaitingRoom = new PrivateWaitingRoom();
//        session.save(privateGameRoom);
//        session.save(privateWaitingRoom);
//        return( (int) privateGameRoomRepository.count() - 1);
//    }

}
