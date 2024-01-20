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

    public enum MessageType {
        JOIN("join"),
        LEAVE("leave"),
        CHAT("chat");

        @Getter
        private final String name;

        MessageType(String name) {
            this.name = name;
        }
    }
}
