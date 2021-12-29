package com.ensias.socialGraphService.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundUser extends FollowServiceException{

	public NotFoundUser(String message) {
		super(message);
	}
	
	public HttpStatus getStatus() {
		return HttpStatus.NOT_FOUND;
	}
}
