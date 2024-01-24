package com.pfplay.chat.controller;

import com.pfplay.chat.exception.UnavailableChatMessageTypeException;
import com.pfplay.chat.model.Chat;
import com.pfplay.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;
    @MessageMapping("/chat/{partyroomId}")
//    @SendTo("/sub/chat/{partyroomId}")
    public ResponseEntity<?> handleChat(@DestinationVariable String partyroomId, Chat chat) throws UnavailableChatMessageTypeException {
        final String topic = partyroomId;
        chatService.handleChat(topic, chat);
        return ResponseEntity.ok(chat);
    }
}
