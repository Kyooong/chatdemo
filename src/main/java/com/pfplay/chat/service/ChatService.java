package com.pfplay.chat.service;

import com.pfplay.chat.model.Chat;
import com.pfplay.chat.model.ChatRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ChatService {
    private Map<String, List<ChatRoom>> chatRoomMap = new HashMap<>();

    public void sendChat(Chat chat) {

    }

    public void addSession(Chat chat) {

    }

    public void removeSession(Chat chat) {

    }
}
