package com.pfplay.chat.service;

import com.pfplay.chat.exception.UnavailableChatMessageTypeException;
import com.pfplay.chat.model.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final RedisPublisher redisPublisher;
    public void handleChat(String topic, Chat chat) throws UnavailableChatMessageTypeException {
        if (chat.getMessageType().equals(Chat.MessageType.JOIN)) {
            enterChat(topic, chat);
            return;
        }

        if (chat.getMessageType().equals(Chat.MessageType.LEAVE)) {
            leaveChat(topic, chat);
            return;
        }

        if (chat.getMessageType().equals(Chat.MessageType.CHAT)) {
            sendChat(topic, chat);
            return;
        }

        throw new UnavailableChatMessageTypeException();
    }


    private void enterChat(String topicName, Chat chat) {
        redisPublisher.publish(new ChannelTopic(topicName), chat);
    }

    private void leaveChat(String topicName, Chat chat) {

    }

    private void sendChat(String topicName, Chat chat) {

    }
}
