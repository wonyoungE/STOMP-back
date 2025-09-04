package com.stomp.chatting.service;

import com.stomp.chatting.dto.ApiRespDto;
import com.stomp.chatting.entity.ChatRoom;
import com.stomp.chatting.repository.ChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {
    @Autowired
    private ChatRoomRepository chatRoomRepository;

    public ApiRespDto<?> getChatRoomList() {
        List<ChatRoom> chatRooms = chatRoomRepository.getChatRoomList();
        return new ApiRespDto<>("success", "채팅방 목록", chatRooms);
    }

    public ApiRespDto<?> getChatRoomByChatRoomId(int chatRoomId) {
        Optional<ChatRoom> optionalChatRoom = chatRoomRepository.getChatRoomByChatRoomId(chatRoomId);

        if(optionalChatRoom.isEmpty()) {
            return new ApiRespDto<>("failed", "채팅방을 찾지 못했습니다.", null);
        }

        return new ApiRespDto<>("success", "채팅방을 찾았습니다.", optionalChatRoom.get());
    }
}
