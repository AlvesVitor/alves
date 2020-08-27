package com.cadastros.alves.exception;

import com.cadastros.alves.enums.ErrorMessagesEnum;

@SuppressWarnings("serial")
public class GenericException extends DefaultException {
	
	@Override
    public ErrorResponse getErrorResponse() {
		return ErrorMessagesEnum.GENERIC_ERROR;
    }

}
