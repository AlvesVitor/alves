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
import com.cadastros.alves.dto.VideoDTO;
import com.cadastros.alves.model.Video;
import com.cadastros.alves.service.VideoService;

@RestController
@RequestMapping("/videos")
public class VideoResource {
	
	@Autowired
	private VideoService videoService;

    @GetMapping
    public ResponseEntity<List<VideoDTO>> getAllVideos(){
        List<VideoDTO> videosdto = videoService.recuperaTodosVideos();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(videosdto);
    }

	@GetMapping("/{codigoVideo}")
	public ResponseEntity<Video> recuperaVideo(@PathVariable(value = "codigoVideo", required = true) Long codigo) {
		Video video = videoService.recuperaVideo(codigo);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(video);
	}

	@PostMapping
	public ResponseEntity<Video> cadastraVideo(@RequestBody VideoDTO videodto) {
		Video videoSalvo = videoService.salvarVideo(videodto);
		return ResponseEntity.status(HttpStatus.CREATED).body(videoSalvo);
	}
	
	@PutMapping("/{codigoVideo}")
	public ResponseEntity<Video> atualizaVideo(@RequestBody Video video,
			@PathVariable(value = "codigoVideo", required = true) Long codigo) throws Exception {
		video = videoService.atualizar(codigo, video);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(video);
	}

}
