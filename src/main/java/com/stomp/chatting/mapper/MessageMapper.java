package com.stomp.chatting.mapper;

import com.stomp.chatting.entity.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageMapper {

    int insertMessage(Message message);
    Message getMessageByMessageId(int messageId);
}
