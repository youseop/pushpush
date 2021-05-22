package com.pushpush.server.respository;

import com.pushpush.server.vo.PrivateGameRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrivateGameRoomRepository extends JpaRepository<PrivateGameRoom, Integer> {

}
