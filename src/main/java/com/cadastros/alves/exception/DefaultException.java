package com.cadastros.alves.exception;



@SuppressWarnings("serial")
public abstract class DefaultException extends RuntimeException{

	public abstract ErrorResponse getErrorResponse();
	 @Override
	    public String getMessage() {
	        return getErrorResponse().getMensagem();
	    }
}
