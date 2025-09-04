package com.stomp.chatting.service;

import com.stomp.chatting.dto.ApiRespDto;
import com.stomp.chatting.dto.userDto.SignupReqDto;
import com.stomp.chatting.entity.User;
import com.stomp.chatting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ApiRespDto<?> signup(SignupReqDto signupReqDto) {
        Optional<User> optionalUser = userRepository.getUserByUsername(signupReqDto.getUsername());
        if(optionalUser.isPresent()) {
            return new ApiRespDto<>("failed", "사용중인 이름", null);
        }

        int result = userRepository.signup(signupReqDto.toEntity());

        if(result != 1) {
            return new ApiRespDto<>("failed", "회원가입 실패", null);
        }

        return new ApiRespDto<>("success", "회원가입 성공", null);
    }

    public ApiRespDto<?> getUserByUserId(int userId) {
        Optional<User> optionalUser = userRepository.getUserByUserId(userId);

        if(optionalUser.isEmpty()) {
            return new ApiRespDto<>("failed", "사용자가 없음", null);
        }

        return new ApiRespDto<>("success", "사용자 찾음", optionalUser.get());
    }

    public ApiRespDto<?> getUserByUsername(String username) {
        Optional<User> optionalUser = userRepository.getUserByUsername(username);

        if(optionalUser.isEmpty()) {
            return new ApiRespDto<>("failed", "사용자가 없음", null);
        }

        return new ApiRespDto<>("success", "사용자 찾음", optionalUser.get());
    }
}
