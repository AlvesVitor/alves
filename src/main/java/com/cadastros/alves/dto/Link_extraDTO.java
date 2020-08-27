package com.cadastros.alves.dto;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Link_extraDTO {

	private String text;
	private String url;
}
