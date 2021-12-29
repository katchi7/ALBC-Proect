package com.twitter.directmessaging.services;

import com.twitter.directmessaging.models.ChatMessage;
import org.springframework.stereotype.Service;

@Service
public interface ChatMessageService {

    void save(ChatMessage chatMessage);

}
