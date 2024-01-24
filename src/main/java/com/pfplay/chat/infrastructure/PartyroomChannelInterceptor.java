package com.pfplay.chat.infrastructure;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class PartyroomChannelInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
        StompCommand command = accessor.getCommand();
        if (command.compareTo(StompCommand.SUBSCRIBE) == 0) {
            String destination = accessor.getDestination();
            System.out.println("subscribe address : " + destination);
            System.out.println(message);
        } else if (command.compareTo(StompCommand.CONNECT) == 0) {
            accessor.getHeader("user");
            accessor.getHeader("partyroomId");
            //validation()
            System.out.println("user connected");
        } else if (command.compareTo(StompCommand.DISCONNECT) == 0) {
            System.out.println("user disconnected");
        }
        return message;
    }
}
