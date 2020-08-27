package com.cadastros.alves.exception.categoria;

import com.cadastros.alves.enums.ErrorMessagesEnum;
import com.cadastros.alves.exception.DefaultException;
import com.cadastros.alves.exception.ErrorResponse;

@SuppressWarnings("serial")
public class CategoriaNotFoundException extends DefaultException{
	
	@Override
    public ErrorResponse getErrorResponse() {
        return ErrorMessagesEnum.ERROR_CATEGORIA_NAO_ENCONTRADA;
    }

}
