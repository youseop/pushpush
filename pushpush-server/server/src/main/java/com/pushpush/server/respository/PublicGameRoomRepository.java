package com.pushpush.server.respository;

import com.pushpush.server.vo.PublicGameRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicGameRoomRepository extends JpaRepository<PublicGameRoom, Integer> {
    PublicGameRoom findByNumber(Integer number);
}
