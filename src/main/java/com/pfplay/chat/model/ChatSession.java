package com.pfplay.chat.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

@RequiredArgsConstructor
@Getter
public class ChatSession {
    private WebSocketSession session;
    private String userName;
    private String userRole;

}
