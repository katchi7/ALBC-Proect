package com.ensias.albctweetservice.Exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data

public class TweetServiceException extends RuntimeException {
    private HttpStatus status;
    public TweetServiceException(HttpStatus status,String message){
        super(message);
        this.status = status;
    }
}
