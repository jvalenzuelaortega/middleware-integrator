package com.example.middleware.infrastructure.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.middleware.infrastructure.api.dto.PostDto;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface PostApiClient {
	
	@GetMapping("/posts")
    List<PostDto> getPosts();

}
