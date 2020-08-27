package com.cadastros.alves.model;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Link_extra {
	
	private String text;
	private String url;

	
}
