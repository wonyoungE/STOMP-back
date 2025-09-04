package com.stomp.chatting.service;

import com.stomp.chatting.dto.ApiRespDto;
import com.stomp.chatting.dto.JoinDto;
import com.stomp.chatting.dto.LeaveDto;
import com.stomp.chatting.dto.MessageReqDto;
import com.stomp.chatting.entity.ChatRoom;
import com.stomp.chatting.entity.Message;
import com.stomp.chatting.entity.User;
import com.stomp.chatting.repository.ChatRoomRepository;
import com.stomp.chatting.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public ApiRespDto<?> insertMessage(MessageReqDto messageReqDto) {
        Optional<Message> optionalMessage = messageRepository.insertMessage(messageReqDto.toEntity());

        if(optionalMessage.isEmpty()) {
            return new ApiRespDto<>("failed", "메세지 전송 실패..", null);
        }

        int messageId = optionalMessage.get().getMessageId();

        Message message = messageRepository.getMessageByMessageId(messageId);

        return new ApiRespDto<>("success", "메세지 전송 성공", message);
    }

    // 입장 메세지
    public ApiRespDto<?> enterChatRoom(Integer roomId, JoinDto joinDto) {
        Message enterMessage = Message.builder()
                .chatRoomId(roomId)
                .userId(1)
                .content(joinDto.getUsername() + "님이 입장했습니다.")
                .type("JOIN")
                .build();

        Optional<Message> optionalMessage = messageRepository.insertMessage(enterMessage);

        if(optionalMessage.isEmpty()) {
            return new ApiRespDto<>("failed", "메세지 전송 실패..", null);
        }

        int messageId = optionalMessage.get().getMessageId();

        Message message = messageRepository.getMessageByMessageId(messageId);

        return new ApiRespDto<>("success", "메세지 전송 성공", message);
    }

    // 퇴장 메세지
    public ApiRespDto<?> leaveChatRoom(Integer roomId, LeaveDto leaveDto) {
        Message leaveMessage = Message.builder()
                .chatRoomId(roomId)
                .userId(1)
                .content(leaveDto.getUsername() + "님이 퇴장했습니다.")
                .type("LEAVE")
                .build();

        Optional<Message> optionalMessage = messageRepository.insertMessage(leaveMessage);

        if(optionalMessage.isEmpty()) {
            return new ApiRespDto<>("failed", "메세지 전송 실패..", null);
        }

        int messageId = optionalMessage.get().getMessageId();

        Message message = messageRepository.getMessageByMessageId(messageId);

        return new ApiRespDto<>("success", "메세지 전송 성공", message);
    }
}
