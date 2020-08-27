package com.cadastros.alves.dto;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Embedded;

import com.cadastros.alves.model.Categoria;
import com.cadastros.alves.model.Link_extra;

import lombok.Data;

@Data
public class CategoriaDTO {
	
	private Long id;
	private String titulo;
	private String cor;
	private String descricao;
	private List<VideoDTO> videos;
	@Embedded
	private Link_extra link_extra;
	
	public CategoriaDTO() {
		
		
	}
	
	public CategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.titulo = categoria.getTitulo();
		this.cor = categoria.getCor();
		this.descricao = categoria.getDescricao();
		this.videos = new ArrayList<>();
		this.videos.addAll(categoria.getVideos().stream().map(VideoDTO::new).collect(Collectors.toList()));
		
		
	}
	
	
	
	

}
