package com.pushpush.server.respository;

import com.pushpush.server.vo.PublicGameRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

public interface PublicGameRoomRepository extends JpaRepository<PublicGameRoom, Integer> {

    PublicGameRoom findByNumber(Integer number);
}
