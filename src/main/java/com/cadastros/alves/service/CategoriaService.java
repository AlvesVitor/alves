package com.cadastros.alves.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cadastros.alves.dto.CategoriaDTO;
import com.cadastros.alves.exception.categoria.CategoriaNotFoundException;
import com.cadastros.alves.model.Categoria;
import com.cadastros.alves.repository.CategoriaRepository;


@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria recuperaCategoria(Long codigo) {
		Categoria categoria = new Categoria();
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(codigo);

		if (categoriaOptional.isPresent()) {
			categoria = categoriaOptional.get();
		} else {
			 throw new CategoriaNotFoundException();
		}
		return categoria;
	}

	public Categoria atualizar(Long codigo, Categoria categoria) throws Exception {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(codigo);
		if (categoriaOptional.isPresent()) {
			Categoria categoriaSalvo = categoriaOptional.get();
			BeanUtils.copyProperties(categoria, categoriaSalvo, "codigo");
			categoriaRepository.save(categoriaSalvo);
			return categoriaSalvo;
		}else {
			throw new Exception("Categoria não encontrado");
		}		
	}
	
	public Categoria salvarCategoria(Categoria categoria) {
		//VALIDAÇÕES PARA VER SE TODOS OS DADOS ESTÃO DE ACORDO COM OS PADRÕES DA API
		categoriaRepository.save(categoria);
		return categoria;
	}

	public List<CategoriaDTO> recuperaTodosCategorias(){
		List<Categoria> categorias =categoriaRepository.findAll();
		List<CategoriaDTO> categoriasdto = new ArrayList<>();
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Categoria, CategoriaDTO>() {
			@Override
			protected void configure() {
				
			}
		});
	
		for(Categoria categoria:categorias) {
			CategoriaDTO categoriadto = modelMapper.map(categoria, CategoriaDTO.class);
			categoriasdto.add(categoriadto);	
		}
			
		return categoriasdto;
	}
	

}
