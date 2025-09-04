package com.stomp.chatting.dto;

import com.stomp.chatting.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageReqDto {
    private Integer chatRoomId;
    private Integer userId;
    private String content;
    private String type;

    public Message toEntity() {
        return Message.builder()
                .chatRoomId(chatRoomId)
                .userId(userId)
                .content(content)
                .type(type)
                .build();
    }
}
