package com.stomp.chatting.repository;

import com.stomp.chatting.entity.ChatRoom;
import com.stomp.chatting.mapper.ChatRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChatRoomRepository {
    @Autowired
    private ChatRoomMapper chatRoomMapper;

    public List<ChatRoom> getChatRoomList() {
        return chatRoomMapper.getChatRoomList();
    }

    public Optional<ChatRoom> getChatRoomByChatRoomId(int chatRoomId) {
        return chatRoomMapper.getChatRoomByChatRoomId(chatRoomId);
    }
}
