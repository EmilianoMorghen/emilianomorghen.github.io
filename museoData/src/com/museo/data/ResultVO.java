package com.museo.data;

import java.io.Serializable;

public class ResultVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int statusCode = StatusCodes.OK;
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
}
