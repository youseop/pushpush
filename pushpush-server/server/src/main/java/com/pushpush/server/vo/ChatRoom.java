package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chat_room")
public class ChatRoom {



    @Transient
    static int roomCount = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int number;

    public ChatRoom() {
        this.number = roomCount;
        roomCount += 1;
    }

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
