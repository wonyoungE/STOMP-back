package com.stomp.chatting.controller;

import com.stomp.chatting.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    // 클라이언트로부터 메시지를 수신하고
    // 모든 클라이언트에게 송신하는 역할 담당

    // 클라이언트가 메세지 보낼 주소, 앞에 /pub 자동으로 붙여줌
    @MessageMapping("/sendMessage")
    // 메서드가 반환하는 chatMessage 객체를 /sub/public 구독하는 모든 클라이언트에게 전송
    @SendTo("/sub/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

}
