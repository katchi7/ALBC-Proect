package com.twitter.directmessaging.endpoints;


import com.twitter.directmessaging.models.Chat;
import com.twitter.directmessaging.models.ChatMessage;
import com.twitter.directmessaging.models.User;
import com.twitter.directmessaging.services.AuthenticationService;
import com.twitter.directmessaging.services.ChatService;
import com.twitter.directmessaging.utils.ApplicationUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.handler.annotation.MessageMapping;

import java.util.List;

@RequiredArgsConstructor
@RestController("/api/v1/chat")
public class ChatEndpoint {

    private final  AuthenticationService authenticationService=null;
    private final  ChatService chatservice=null;

/*
-- 	Un utilisateur peut démarrer une conversation privée ou créer une conversation de groupe avec ses abonnés.
--  Un utilisateur peut envoyer des messages directement à la personne et qui n'est visible que par celle-ci.
*/

    @GetMapping("/newchat")
    public ResponseEntity<Chat> newChat( @RequestBody User  author,@RequestBody List<User> participants) {
        User auth = authenticationService.getAuthenticatedUser();

        if (auth.equals(author)) {
            Chat newchat = new Chat();
            newchat.setParticipants(participants);
            return new ResponseEntity<>(chatservice.save(newchat),HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>((HttpStatus.UNAUTHORIZED));

    }
/*
-- Chaque utilisateur d'un groupe peut voir tous les messages, même si tout le monde ne se suit pas mutuellement.
 */
@GetMapping("{chatid}/readchat")
public ResponseEntity<List <ChatMessage>> readChat( @RequestBody User  author,@PathVariable Long chatid) {
    User auth = authenticationService.getAuthenticatedUser();
    Chat chat=chatservice.getChatById(chatid);

    if (auth.equals(author) && chat.getParticipants().contains(author) ) {

        return new ResponseEntity<>(chat.getMessages(),HttpStatus.ACCEPTED);
    }
    return new ResponseEntity<>((HttpStatus.UNAUTHORIZED));

}

/*
-- Dans une conversation de groupe, chaque participant peut en ajouter d'autres.
 */
    @GetMapping("/{chatid}/add-participants")
    public ResponseEntity<String> addParticipants(@RequestBody User  author, @PathVariable Long chatid, @RequestBody List<User> participants) {
        User auth = authenticationService.getAuthenticatedUser();
        Chat chat=chatservice.getChatById(chatid);

        if (auth.equals(author) &&  chat.getParticipants().contains(author))
        {
          List<User>  particpantlist=chat.getParticipants();

            for (User participant: participants) particpantlist.add(participant);

            chat.setParticipants(particpantlist);
            chatservice.save(chat);
            return new ResponseEntity<>((HttpStatus.ACCEPTED));
        }
        return new ResponseEntity<>((HttpStatus.UNAUTHORIZED));

    }

/*
--  Un utilisateur peut envoyer des messages directement à la personne et qui n'est visible que par celle-ci.
--	Les abonnés d’un utilisateur peuvent envoyer des messages directs.
 */
    @MessageMapping("/chat")
    public ResponseEntity<String> sendMessage(@Payload ChatMessage chatMessage) {

        chatMessage.setTimestamp(ApplicationUtils.getTime());
        User author = authenticationService.getAuthenticatedUser();

        if(author.equals(chatMessage.getSender()))
        {
            chatservice.getMessagesFromChat(chatMessage.getChat()).add(chatMessage);
            chatservice.notifyRecipient(chatMessage.getChat());
            return new ResponseEntity<>((HttpStatus.ACCEPTED));
        }
        return new ResponseEntity<>((HttpStatus.UNAUTHORIZED));


    }


}
