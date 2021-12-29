package com.ensias.socialGraphService.exceptions;

import org.springframework.http.HttpStatus;

public abstract class FollowServiceException extends RuntimeException {

	public FollowServiceException(String message) {
		super(message);
	}
	
	public abstract HttpStatus getStatus();

}
