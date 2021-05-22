package com.pushpush.server.service;

import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.vo.PublicGameRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PublicGameRoomService {

    // save

    private final PublicGameRoomRepository publicGameRoomRepository;

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
