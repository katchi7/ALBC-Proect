package com.twitter.directmessaging.services;

import com.twitter.directmessaging.models.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User getAuthenticatedUser();
}
