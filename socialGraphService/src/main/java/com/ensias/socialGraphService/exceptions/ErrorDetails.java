package com.ensias.socialGraphService.exceptions;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

public class ErrorDetails {

	private String message;
	
	private String uri;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timesTamp;
	
	public ErrorDetails() {
		this.timesTamp = new Date();
	}
	
	public ErrorDetails(String message, String uri) {
		this();
		this.message = message;
		this.uri = uri;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Date getTimesTamp() {
		return timesTamp;
	}
	public void setTimesTamp(Date timesTamp) {
		this.timesTamp = timesTamp;
	}
	
	
}
