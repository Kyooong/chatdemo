package com.pfplay.chat.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfplay.chat.model.Chat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisSubscriber implements MessageListener {
    private final ObjectMapper objectMapper;
    private final RedisTemplate redisTemplate;
    private final SimpMessageSendingOperations messagingTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        try {
            final String publishMessage = (String) redisTemplate.getStringSerializer().deserialize(message.getBody());
            final Chat chat = objectMapper.readValue(publishMessage, Chat.class);

            if (chat.getMessageType().equals(Chat.MessageType.CHAT)) {
                System.out.println(chat.getUser().getNickname());
                messagingTemplate.convertAndSend("/sub/chat/" + chat.getTopic(), chat);
                return;
            }

            if (chat.getMessageType().equals(Chat.MessageType.JOIN)) {
                messagingTemplate.convertAndSend("/sub/chat/" + chat.getTopic(), chat);
                return;
            }

            if (chat.getMessageType().equals(Chat.MessageType.LEAVE)) {
                messagingTemplate.convertAndSend("/sub/chat/" + chat.getTopic(), chat);
                return;
            }

            throw new Exception();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
