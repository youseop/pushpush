package com.pushpush.server.vo;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "public_waiting_room")
public class PublicWaitingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private List<String> users = new ArrayList<>();
    private static Integer totalNumber = 4;

}
