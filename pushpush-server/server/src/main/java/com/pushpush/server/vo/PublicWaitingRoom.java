package com.pushpush.server.vo;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "public_waiting_room")
@RequiredArgsConstructor
public class PublicWaitingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "num_of_current_users")
    private Integer NumOfCurrentUsers;

}
