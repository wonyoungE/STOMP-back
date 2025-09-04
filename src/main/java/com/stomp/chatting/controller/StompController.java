package com.stomp.chatting.controller;

import com.stomp.chatting.MessageType;
import com.stomp.chatting.dto.ApiRespDto;
import com.stomp.chatting.dto.JoinDto;
import com.stomp.chatting.dto.LeaveDto;
import com.stomp.chatting.dto.MessageReqDto;
import com.stomp.chatting.entity.Message;
import com.stomp.chatting.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class StompController {
    // 클라이언트로부터 메시지를 수신하고
    // 모든 클라이언트에게 송신하는 역할 담당

    @Autowired
    private MessageService messageService;

    // messageMapping -> config에서 setApplicationDestinationPrefixes로 설정해준
    // /pub이 앞에 자동 매핑

    // 클라이언트가 메세지 발행하는 주소, 앞에 /pub 자동으로 붙여줌
    // 클라이언트가 pub으로 발행하니까 pub으로 받아야됨
    @MessageMapping("/send")
    // 메서드가 반환하는 chatMessage 객체를 /sub/public 구독하는 모든 클라이언트에게 전송
    @SendTo("/sub/public")  // 클라이언트가 sub으로 구독하니까 sub으로 보내야함
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    // 입장 시 메시지
    @MessageMapping("/join/{roomId}") // /pub/join/{roomId}
    @SendTo("/sub/chat/room/{roomId}")   // 클라이언트가 구독한 주소
    public ApiRespDto<?> enterChatRoom(@DestinationVariable Integer roomId, @Payload JoinDto joinDto) {
        // usename만 와도 JSON 형태로 오기 때문에 객체로 받아야 됨
        return messageService.enterChatRoom(roomId, joinDto);
    }

    // 퇴장 시 메시지
    @MessageMapping("/leave/{roomId}") // /pub/join/{roomId}
    @SendTo("/sub/chat/room/{roomId}")   // 클라이언트가 구독한 주소
    public ApiRespDto<?> leaveChatRoom(@DestinationVariable Integer roomId, @Payload LeaveDto leaveDto) {
        // usename만 와도 JSON 형태로 오기 때문에 객체로 받아야 됨
        return messageService.leaveChatRoom(roomId, leaveDto);
    }

    @MessageMapping("/chat/room/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    public ApiRespDto<?> message(@DestinationVariable String roomId, MessageReqDto messageReqDto) {
        return messageService.insertMessage(messageReqDto);
    }

}
