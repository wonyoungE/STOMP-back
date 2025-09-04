package com.stomp.chatting.mapper;

import com.stomp.chatting.entity.ChatRoom;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ChatRoomMapper {
    List<ChatRoom> getChatRoomList();
    Optional<ChatRoom> getChatRoomByChatRoomId(int chatRoomId);
}
