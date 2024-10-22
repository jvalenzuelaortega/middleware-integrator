package com.example.middleware.infrastructure.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.middleware.infrastructure.api.dto.PostDto;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface PostApiClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<PostDto> getPosts();

}
