package com.pfplay.chat.interceptor;

import com.pfplay.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class ChatInterceptor extends HttpSessionHandshakeInterceptor {
    private final ChatService chatService;

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        // 인증과정
        // 1. security
        // 2. ban user 조회 후 차단

        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
}
