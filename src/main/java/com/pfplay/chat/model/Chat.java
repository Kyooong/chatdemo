package com.pfplay.chat.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Chat {
    private Long id;
    private User user;
    private String message;
    private String topic;
    private MessageType messageType;

    private enum MessageType {
        JOIN, LEAVE, CHAT
    }
}
