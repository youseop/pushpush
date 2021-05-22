package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "private_waiting_room")
public class PrivateWaitingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;


    //private List<String> users = new ArrayList<>();

    @Column(name = "num_of_current_users")
    private Integer NumOfCurrentUsers;
}
