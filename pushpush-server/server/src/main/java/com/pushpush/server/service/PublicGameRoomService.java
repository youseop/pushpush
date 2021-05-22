package com.pushpush.server.service;

import com.pushpush.server.respository.PublicGameRoomRepository;
import com.pushpush.server.vo.PublicGameRoom;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository("publicGameRoomService")
@Transactional()
public class PublicGameRoomService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    PublicGameRoomRepository publicGameRoomRepository;


    public void insert(PublicGameRoom publicGameRoom) {
        Session session = entityManager.unwrap(Session.class);
        session.save(publicGameRoom);
        session.flush();
    }

    /*public int size() {
        return this.entityManager.createQuery();
    }*/

}
