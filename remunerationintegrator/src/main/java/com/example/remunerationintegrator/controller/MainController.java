package com.example.remunerationintegrator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.remunerationintegrator.service.AlbumService;

import reactor.core.publisher.Mono;

@RestController
public class MainController {
	
	private AlbumService albumService;
	
	
	public MainController(AlbumService albumService) {
		this.albumService = albumService;
	}

	@GetMapping("/main")
	public Mono<ResponseEntity<String>> getHello() {
		String response = albumService.getAlbumList();
		
		return Mono.just(ResponseEntity.ok(response));
	}
}
