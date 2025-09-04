package com.stomp.chatting.dto.userDto;

import com.stomp.chatting.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupReqDto {
    private String username;

    public User toEntity() {
        return User.builder()
                .username(username)
                .build();
    }
}
