package com.example.springboot1800flower.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot1800flower.model.Post;
import com.example.springboot1800flower.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> getPostList() {
		return postRepository.getPostList();
	}

	public Post getPostById(int id) {
		return postRepository.getPostById(id);

	}

	public String updatePostById(int id, Post post) {
		return postRepository.updatePostById(id, post);
	}

	public Integer getCountOfUniqueUserIds() {
		return postRepository.getCountOfUniqueUserIds();
	}
}
