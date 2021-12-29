package com.twitter.directmessaging.services;



import com.twitter.directmessaging.models.Chat;
import com.twitter.directmessaging.models.ChatMessage;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ChatService {

    void notifyRecipient(Chat chat);

    List<ChatMessage> getMessagesFromChat(Chat chat);

    Chat save(Chat newchat);

    Chat getChatById(Long chatid);
}