package com.cadastros.alves.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponseDTO {
	
    private String code;
    private String message;
    private String externalMessage;

    public ErrorResponseDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
