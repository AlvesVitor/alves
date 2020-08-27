package com.cadastros.alves.exception;

import org.springframework.http.HttpStatus;

public interface ErrorResponse {

	 HttpStatus getHttpStatus();
	    String getMensagem();
	    String getCodigo();

	    default String getExternalMensage(){
	        return  null;
	    }
}
