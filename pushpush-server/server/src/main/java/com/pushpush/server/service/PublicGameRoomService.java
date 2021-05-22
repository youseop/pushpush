package com.pushpush.server.service;

import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.vo.PublicGameRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class PublicGameRoomService {

    // save

    //@Autowired
    private final PublicGameRoomRepository publicGameRoomRepository;


//    public PublicGameRoomService() {
//        this.publicGameRoomRepository =
//    }

    @Transactional
    public void insert(PublicGameRoom publicGameRoom) {
        publicGameRoomRepository.save(publicGameRoom);
    }

    @Transactional
    public Long size() {
        return publicGameRoomRepository.count();
    }

    /*public int size() {
        return this.entityManager.createQuery();
    }*/

}
