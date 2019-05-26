package com.syntel.orion.io;

import com.syntel.orion.util.ResponseStatusCode;

public class BaseResponse {

	private ResponseStatusCode status;
	private int errorCode;
	private String errorMessage;
	
	public BaseResponse() {}
	
	public BaseResponse(ResponseStatusCode status) {
		this.status = status;
	}
	
	public ResponseStatusCode getStatus() {
		return status;
	}
	
	public void setStatus(ResponseStatusCode status) {
		this.status = status;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
}
