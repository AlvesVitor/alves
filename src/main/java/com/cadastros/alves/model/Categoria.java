package com.cadastros.alves.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Data;

@Entity(name = "categoria")
@Table(name = "categoria")
@Data
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String cor;
	private String descricao;
	@Embedded
	private Link_extra link_extra;
	@OneToMany(mappedBy = "categoriaId")
	private List<Video> videos = new ArrayList<Video>();
	

	public Categoria() {
		
	}
	
	/*public Categoria(Long id, String titulo, String cor, String descricao, Link_extra link_extra, List<Video> videos) {
		
		this.id = id;
		this.titulo = titulo;
		this.cor = cor;
		this.descricao = descricao;
		this.link_extra = link_extra;
		this.videos.addAll(getVideos().stream().collect(Collectors.toList()));
	}
	*/
	
	
}
