package com.test.bowling.bowling.dto;

import org.springframework.http.HttpStatus;

public class ResponseGenericDTO {
	
	private int data;
	private boolean success;
	private String message;
	private HttpStatus status;
	
	
	
	public ResponseGenericDTO() {
		super();
	}

	public ResponseGenericDTO(int data, boolean success, String message, HttpStatus status) {
		super();
		this.data = data;
		this.success = success;
		this.message = message;
		this.status = status;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
