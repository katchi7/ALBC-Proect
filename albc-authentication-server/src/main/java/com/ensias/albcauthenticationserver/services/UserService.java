package com.ensias.albcauthenticationserver.services;


import com.ensias.albcauthenticationserver.api.UserServiceApi;
import com.ensias.albcauthenticationserver.dtos.LoginDto;
import com.ensias.albcauthenticationserver.dtos.UserDto;
import com.ensias.albcauthenticationserver.models.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    private final UserServiceApi api;

    public UserService(UserServiceApi api) {
        this.api = api;
    }

    public User validate(String userName,String password){
        return api.validateUserNamePassword(new LoginDto(userName,password)).asUser();
    }
    public User findUser(String login){
        return api.findUserByLogin(new LoginDto(login,null)).asUser();
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findUser(s);
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(s, "psw", Collections.singletonList(new SimpleGrantedAuthority("USER")));
        return user1;
    }
}
