package com.pfplay.chat.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;
import java.util.Set;

@RedisHash
@RequiredArgsConstructor
@Getter
public class ChatRoom {
    private String topic;
    private Set<ChatSession> sessions; // 참여 user list
    private List<String> banUserList;
    private List<String> noChatUserList;
    private List<String> kickUserList;



}
