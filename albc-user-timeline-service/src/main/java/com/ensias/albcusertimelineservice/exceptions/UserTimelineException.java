package com.ensias.albcusertimelineservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
public class UserTimelineException extends RuntimeException {
    private HttpStatus status;
    public UserTimelineException(HttpStatus status,String message){
        super(message);
        this.status = status;
    }
}
