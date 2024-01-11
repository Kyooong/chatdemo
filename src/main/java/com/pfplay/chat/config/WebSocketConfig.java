package com.pfplay.chat.config;

import com.pfplay.chat.handler.ChatHandler;
import com.pfplay.chat.interceptor.ChatInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {
    private final ChatHandler chatHandler;
    private final ChatInterceptor chatInterceptor;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatHandler, "/chat")
                .addInterceptors(chatInterceptor)
                .setAllowedOrigins("*");
    }
}
