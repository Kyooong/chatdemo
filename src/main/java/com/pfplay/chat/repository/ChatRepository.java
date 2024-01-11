package com.pfplay.chat.repository;

import com.pfplay.chat.model.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Long> {
}
