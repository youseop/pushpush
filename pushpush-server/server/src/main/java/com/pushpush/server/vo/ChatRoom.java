package com.pushpush.server.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Data
@Entity
public class ChatRoom {


    @Transient
    static int roomCount = 0;
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
