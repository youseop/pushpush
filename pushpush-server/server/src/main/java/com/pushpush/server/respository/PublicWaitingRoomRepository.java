package com.pushpush.server.respository;

import com.pushpush.server.vo.PublicWaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicWaitingRoomRepository extends JpaRepository<PublicWaitingRoom, Integer> {
}
