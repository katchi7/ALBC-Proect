package com.ensias.albcuserService.exceptions;

import org.springframework.http.HttpStatus;


public class UserServiceException extends RuntimeException {
    private HttpStatus status;
    private String message;
    public UserServiceException(HttpStatus status,String message){
        this.message = message;
        this.status = status;
    }
}
