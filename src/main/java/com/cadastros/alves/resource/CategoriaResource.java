package com.cadastros.alves.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cadastros.alves.dto.CategoriaDTO;
import com.cadastros.alves.model.Categoria;
import com.cadastros.alves.service.CategoriaService;


@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias(){
        List<CategoriaDTO> categoriasdto = categoriaService.recuperaTodosCategorias();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoriasdto);
    }

	@GetMapping("/{codigoCategoria}")
	public ResponseEntity<Categoria> recuperaCategoria(@PathVariable(value = "codigoCategoria", required = true) Long codigo) {
		Categoria categoria = categoriaService.recuperaCategoria(codigo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoria);
	}

	@PostMapping
	public ResponseEntity<Categoria> cadastraCategoria(@RequestBody Categoria categoria) {
		Categoria categoriaSalvo = categoriaService.salvarCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalvo);
	}
	
	@PutMapping("/{codigoCategoria}")
	public ResponseEntity<Categoria> atualizaCategoria(@RequestBody Categoria categoria,
			@PathVariable(value = "codigoCategoria", required = true) Long codigo) throws Exception {
		categoria = categoriaService.atualizar(codigo, categoria);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(categoria);
	}

}
