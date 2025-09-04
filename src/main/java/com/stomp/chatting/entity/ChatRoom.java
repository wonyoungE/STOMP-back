package com.stomp.chatting.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ChatRoom {
    private String chatRoomId;
    private String roomName;
    private LocalDateTime createDt;

    private List<Message> messageList;

    /*public static ChatRoom create(String roomName) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.roomId = UUID.randomUUID().toString();
        chatRoom.roomName = roomName;
        return chatRoom;
    }*/

}
