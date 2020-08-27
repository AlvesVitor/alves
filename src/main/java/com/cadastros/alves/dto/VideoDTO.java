package com.cadastros.alves.dto;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cadastros.alves.model.Video;

import lombok.Data;



@Data
public class VideoDTO {
	
	@NotNull @NotEmpty
	private Long id;
	@NotNull @NotEmpty
	private Long categoriaId;
	@NotNull @NotEmpty
	private String titulo;
	@NotNull @NotEmpty
	private String url;
	
	public VideoDTO(Video video) {
		this.id = video.getId();
		this.categoriaId = video.getCategoriaId().getId();
		this.titulo = video.getTitulo();
		this.url = video.getUrl();
		
	}
	
	public VideoDTO() {
		
		
	}
	
	
}
