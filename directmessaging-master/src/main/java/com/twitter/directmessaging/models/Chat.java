package com.twitter.directmessaging.models;

import com.twitter.directmessaging.utils.ApplicationUtils;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class Chat {


    private Long id;

    private Date creationDate;

    private List<User> participants;

    private List<ChatMessage> messages;

    public Chat() {
        creationDate= ApplicationUtils.getTime();
    }
}