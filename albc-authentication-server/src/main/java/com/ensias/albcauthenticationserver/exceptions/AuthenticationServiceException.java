package com.ensias.albcauthenticationserver.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class AuthenticationServiceException extends RuntimeException {
    private HttpStatus status;
    private String message;
    public AuthenticationServiceException(HttpStatus status,String message){
        this.message = message;
        this.status = status;
    }
}
