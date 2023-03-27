package com.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class Error {

	private LocalDateTime localDate;
	private String message;
	private String details;
	
	public Error(LocalDateTime localDate, String message, String details) {
		super();
		this.localDate = localDate;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDateTime localDate) {
		this.localDate = localDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
}
