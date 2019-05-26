package com.syntel.orion.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7049456359370083030L;

	public EntityNotFoundException() {}
	
	public EntityNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
