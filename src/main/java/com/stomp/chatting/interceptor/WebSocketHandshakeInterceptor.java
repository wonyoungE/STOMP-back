//package interceptor;
//
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.server.HandshakeInterceptor;
//
//import java.util.Map;
//
//// Security 사용하면 authentication(인증 정보)를 웹소켓에 옮겨주기!
//public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
//
//    @Override
//    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
//        // beforeHandShake: 웹소켓 연결 직전에 호출
//
//        // SecurityContextHolder에서 Authentication 가져오기
////            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        if(authentication != null) { // 인증 객체 존재할 시
////            attributes.put("authentication", authetication);    // WebSocket에 인증 객체 넣어주기
////        }
//
//        return true; // 핸드셰이크 허용
//    }
//
//    @Override
//    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
//
//    }
//}
