package com.stomp.chatting.repository;

import com.stomp.chatting.entity.Message;
import com.stomp.chatting.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageMapper messageMapper;

    public Optional<Message> insertMessage(Message message){
        try {
            messageMapper.insertMessage(message);
        } catch (DuplicateKeyException e) {
            return Optional.empty();
        }

        return Optional.of(message);
    }

    public Message getMessageByMessageId(int messageId) {
        return messageMapper.getMessageByMessageId(messageId);
    }
}
