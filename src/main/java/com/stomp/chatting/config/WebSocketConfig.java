package com.stomp.chatting.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker    // WebSocket 메시지 처리 기능 활성화
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    // WebSocket
    // 클라이언트와 서버 간의 양방향 통신을 가능하게 하는 프로토콜

    // STOMP(Simple Text Oriented Messaging Protocol)
    // WebSocket 위에서 텍스트 기반 메시징 프로토콜 (PUB/SUB 기반)
    // @MessageMapping과 같은 어노테이션을 이용해
    // 메시지 발행 시 엔드포인트 별도 분리해서 관리 가능
    // CONNECT: 클라이언트가 서버에 연결 요청
    // SEND: 특정 목적지로 메시지 송신
    // SUBSCRIBE: 특정 주제 구독해 메시지 수신
    // UNSUBSCRIBE: 구독 해제
    // DISCONNECT: 연결 종료
    // Topic 기반 메시징(1:N) => /topic
    // 여러 클라이언트 동일한 주제 구독
    // 서버는 해당 주제의 메시지를 모든 구독자에게 Broadcast
    // 해당 주제를 구독한 다수의 수신자가 메시지를 동시에 받을 수 있음
    // Queue 기반 메시징(1:1) => /queue
    // 단일 클라이언트에게 메시지를 전달하는 방식
    // 메시지는 대기열에 저장, 해당 대기열을 구독한 클라이언트가 메시지 처리


    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 메세지 구독 요청 url
        registry.enableSimpleBroker("/sub");
        // 메세지 발행 요청 url
        registry.setApplicationDestinationPrefixes("/pub");
    }

    // WebSocket에 접속하기 위한 endpoint 설정
    // 도메인이 다른 서버에서도 접속 가능하도록 CORS 설정
    // 클라이언트는 http가 아닌 ws로 연결, 통신
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // http://localhost:8080/ws
        // 다른 도메인에서도 접속 가능하게 CORS 설정
        // 실제 서비스에서는 특정 주소만 허용(ex. 프론트엔드 주소만 허용)
        registry.addEndpoint("/ws-stomp")
                .setAllowedOriginPatterns("*")
                .withSockJS();  // WebSocket 연결 엔드포인트
        // sockjs는 WebSocket을 지원하지 않는 버전의 브라우저에서
        // WebSocket을 사용할 수 있게 해주는 라이브러리
    }
}
