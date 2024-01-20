package com.pfplay.chat.controller;

import com.pfplay.chat.exception.UnavailableChatMessageTypeException;
import com.pfplay.chat.model.Chat;
import com.pfplay.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @MessageMapping("/chat/{partyroomId}")
    public void handleChat(@DestinationVariable String partyroomId, @Payload Chat chat) throws UnavailableChatMessageTypeException {
        final String topic = partyroomId;
        chatService.handleChat(topic, chat);
    }
}
