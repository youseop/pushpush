package com.pushpush.server.respository;

import com.pushpush.server.vo.PrivateWaitingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateWaitingRoomRepository extends JpaRepository<PrivateWaitingRoom, Integer> {

}
