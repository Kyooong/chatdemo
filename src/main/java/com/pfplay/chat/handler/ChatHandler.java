package com.pfplay.chat.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfplay.chat.model.Chat;
import com.pfplay.chat.service.ChatService;
import jdk.jshell.spi.ExecutionControlProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class ChatHandler extends TextWebSocketHandler {
    private final ObjectMapper mapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        Chat chat = mapper.readValue(payload, Chat.class);

        if (chat.getMessageType() == Chat.MessageType.CHAT) {
            chatService.sendChat(chat);
            return;
        }

        if (chat.getMessageType() == Chat.MessageType.JOIN) {
            chatService.addSession(chat);
            return;
        }

        if (chat.getMessageType() == Chat.MessageType.LEAVE) {
            chatService.removeSession(chat);
            return;
        }

        throw new Exception();
    }
}
