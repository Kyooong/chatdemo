package com.pfplay.chat.service;

import com.pfplay.chat.model.Chat;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    public void publish(ChannelTopic topic, Chat chat) {
        redisTemplate.convertAndSend(topic.getTopic(), chat);
    }
}
