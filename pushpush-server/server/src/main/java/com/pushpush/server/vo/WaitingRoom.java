package com.pushpush.server.vo;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "waiting_room")
public class WaitingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "waitingRoom")
    private ChatRoom chatRoom;
    private List<String> users = new ArrayList<>();
    private static Integer totalNumber = 4;

}
