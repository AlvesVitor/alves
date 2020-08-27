package com.cadastros.alves.exception.video;

import com.cadastros.alves.enums.ErrorMessagesEnum;
import com.cadastros.alves.exception.DefaultException;
import com.cadastros.alves.exception.ErrorResponse;

@SuppressWarnings("serial")
public class VideoNotFoundException extends DefaultException {
	
	@Override
    public ErrorResponse getErrorResponse() {
        return ErrorMessagesEnum.ERROR_VIDEO_NAO_ENCONTRADO;
    }

}
