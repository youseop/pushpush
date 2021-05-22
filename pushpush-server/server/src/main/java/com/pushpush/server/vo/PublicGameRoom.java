package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "game_room")
public class PublicGameRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer number;


}
