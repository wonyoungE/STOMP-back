package com.stomp.chatting.controller;

import com.stomp.chatting.service.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping("/room/list")
    public ResponseEntity<?> getChatRoomList() {
        return ResponseEntity.ok(chatRoomService.getChatRoomList());
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<?> getChatRoomAndChatByRoomId(@PathVariable Integer roomId) {
        return ResponseEntity.ok(chatRoomService.getChatRoomByChatRoomId(roomId));
    }
}