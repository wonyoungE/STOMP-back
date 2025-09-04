package com.stomp.chatting.mapper;

import com.stomp.chatting.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {

    int signup(User user);
    Optional<User> getUserByUserId(int userId);
    Optional<User> getUserByUsername(String username);
}
