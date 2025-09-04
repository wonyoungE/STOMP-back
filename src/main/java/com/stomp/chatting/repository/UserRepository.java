package com.stomp.chatting.repository;

import com.stomp.chatting.entity.User;
import com.stomp.chatting.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserMapper userMapper;

    public int signup(User user) {
        return userMapper.signup(user);
    }

    public Optional<User> getUserByUserId(int userId) {
        return userMapper.getUserByUserId(userId);
    }
    public Optional<User> getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }
}
