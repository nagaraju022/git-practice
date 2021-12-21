package com.example.springboot1800flower.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot1800flower.model.Post;
import com.example.springboot1800flower.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService postService;

	@GetMapping("/posts")
	public List<Post> getPostList() {
		return postService.getPostList();
	}

	@PutMapping("/posts/update/{id}")
	public String updatePost(@PathVariable("id") int id, @RequestBody Post post) {
		return postService.updatePostById(id, post);

	}

	@GetMapping("/posts/count")
	public Integer getCountOfUniqueUserIds() {
		return postService.getCountOfUniqueUserIds();

	}

	@GetMapping("/posts/{id}")
	public Post getPostById(@PathVariable("id") int id) {
		return postService.getPostById(id);

	}

}
