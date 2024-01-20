package com.pfplay.chat.infrastructure;

import com.pfplay.chat.model.Chat;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<Chat, Long> {
}
