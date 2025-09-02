package com.stomp.chatting.model;

import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;

}
