package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "private_game_room")
public class PrivateGameRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer number;

    boolean isFull;

}
