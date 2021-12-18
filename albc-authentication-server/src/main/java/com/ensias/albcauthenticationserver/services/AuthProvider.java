package com.ensias.albcauthenticationserver.services;

import com.ensias.albcauthenticationserver.models.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Log4j2
public class AuthProvider implements AuthenticationProvider {
    private final UserService userService;

    public AuthProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("name : "+authentication.getPrincipal());
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        // use the credentials
        User user = userService.validate(name,password);
        log.info(user);
        // and authenticate against the third-party system
        return new UsernamePasswordAuthenticationToken(
                name, password, new ArrayList<>());

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
