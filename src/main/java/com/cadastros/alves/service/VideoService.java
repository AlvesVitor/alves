package com.cadastros.alves.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cadastros.alves.dto.VideoDTO;
import com.cadastros.alves.exception.categoria.CategoriaNotFoundException;
import com.cadastros.alves.exception.video.VideoNotFoundException;
import com.cadastros.alves.model.Categoria;
import com.cadastros.alves.model.Video;
import com.cadastros.alves.repository.CategoriaRepository;
import com.cadastros.alves.repository.VideoRepository;

@Service
public class VideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Video recuperaVideo(Long codigo) {
		Video video = new Video();
		Optional<Video> videoOptional = videoRepository.findById(codigo);

		if (videoOptional.isPresent()) {
			video = videoOptional.get();
		} else {
			 throw new VideoNotFoundException();
		}
		return video;
	}

	public Video atualizar(Long codigo, Video video) throws Exception {
		Optional<Video> videoOptional = videoRepository.findById(codigo);
		if (videoOptional.isPresent()) {
			Video videoSalvo = videoOptional.get();
			BeanUtils.copyProperties(video, videoSalvo, "codigo");
			videoRepository.save(videoSalvo);
			return videoSalvo;
		}else {
			
			throw new VideoNotFoundException();
		}		
	}
	
	public Video salvarVideo(VideoDTO videodto) {
		Video video = new Video();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<VideoDTO, Video>() {
			@Override
			protected void configure() {
				skip(destination.getCategoriaId());
			}
		});

		video = modelMapper.map(videodto, Video.class);
		Optional<Categoria> categoriaCodigo = categoriaRepository.findById(videodto.getCategoriaId());
		if (categoriaCodigo.isPresent()) {
			video.setCategoriaId(categoriaCodigo.get());
		} else {
			throw new CategoriaNotFoundException();
		}
		videoRepository.save(video);

		return video;
	}

	public List<VideoDTO> recuperaTodosVideos() {

		List<Video> videos = videoRepository.findAll();
		List<VideoDTO> videosdto = new ArrayList<>();

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addMappings(new PropertyMap<Video, VideoDTO>() {
			@Override
			protected void configure() {
				skip(destination.getId());
			}
		});
		
		for(Video video:videos) {
			VideoDTO videodto = modelMapper.map(video, VideoDTO.class);
			videosdto.add(videodto);	
		}
		
		return videosdto;
	}

}
