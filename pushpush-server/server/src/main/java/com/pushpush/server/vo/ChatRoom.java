package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chat_room")
public class ChatRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int number;

    public boolean isSameRoomNumber(int roomNumber) {
        return this.number == roomNumber;
    }

    @Override
    public String toString() {
        return "GameRoom{" +
                "Number=" + number +
                '}';
    }

}
