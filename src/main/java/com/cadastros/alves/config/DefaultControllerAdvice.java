package com.cadastros.alves.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cadastros.alves.dto.ErrorResponseDTO;
import com.cadastros.alves.exception.DefaultException;
import com.cadastros.alves.exception.ErrorResponse;
import com.cadastros.alves.exception.GenericException;

@SuppressWarnings("rawtypes")
public class DefaultControllerAdvice {
	
	 @ResponseBody
	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity handle(RuntimeException exception) {
	        ErrorResponse errorResponse = null;
	        if (exception instanceof DefaultException) {
	            DefaultException defaultException = (DefaultException) exception;
	            errorResponse = defaultException.getErrorResponse();
	        } else {
	        	System.out.printf(exception.getMessage());
	            errorResponse = new GenericException().getErrorResponse();
	        }
	        return ResponseEntity
	                .status(errorResponse.getHttpStatus())
	                .body(new ErrorResponseDTO(errorResponse.getCodigo(), errorResponse.getMensagem(), errorResponse.getExternalMensage()));
	    }

}
