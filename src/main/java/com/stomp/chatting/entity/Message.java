package com.stomp.chatting.entity;

import com.stomp.chatting.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer messageId;
    private Integer chatRoomId;
    private Integer userId;
    private String content;
    private String type;
    private LocalDateTime createDt;
    private User user;
}
