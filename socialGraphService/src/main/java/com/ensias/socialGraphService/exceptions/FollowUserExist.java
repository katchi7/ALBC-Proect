package com.ensias.socialGraphService.exceptions;

import org.springframework.http.HttpStatus;

public class FollowUserExist extends FollowServiceException {

	public FollowUserExist(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStatus() {
		return HttpStatus.CONFLICT;
	}
}
