package com.cadastros.alves.enums;

import org.springframework.http.HttpStatus;

import com.cadastros.alves.exception.ErrorResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum ErrorMessagesEnum implements ErrorResponse {
	
	 /**
     * Padrão de Criação de Códigos de Erros: Três primeiros letras do nome do model + código sequêncial - nome da mensagem
     * Por exemplo:  CLI001 - Cliente não encontrado
     */

    GENERIC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "DOM001", "Generic error"),
    ERROR_CATEGORIA_NAO_ENCONTRADA(HttpStatus.NOT_FOUND, "CAT001", "Categoria não encontrada na base de dados"),
    ERROR_VIDEO_NAO_ENCONTRADO(HttpStatus.NOT_FOUND, "VID001", "Video não encontrado na base de dados");

    private final HttpStatus httpStatus;
    private final String codigo;
    private final String mensagem;

}
