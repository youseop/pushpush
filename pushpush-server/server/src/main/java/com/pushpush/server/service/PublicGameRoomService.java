package com.pushpush.server.service;

import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.vo.PublicGameRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PublicGameRoomService {

    // save
    private PublicGameRoomRepository publicGameRoomRepository;


    @Autowired
    public PublicGameRoomService(PublicGameRoomRepository publicGameRoomRepository) {
        this.publicGameRoomRepository = publicGameRoomRepository;
    }

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
