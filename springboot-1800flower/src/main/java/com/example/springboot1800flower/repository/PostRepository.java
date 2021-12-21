package com.example.springboot1800flower.repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.springboot1800flower.model.Post;

@Repository
public class PostRepository {

	@Autowired
	private RestTemplate restTemplate;

	public Post getPostById(int id) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Post> entity = new HttpEntity<>(httpHeaders);
		return restTemplate
				.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.GET, entity, Post.class)
				.getBody();
	}

	public List<Post> getPostList() {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		Post[] posts = restTemplate
				.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, Post[].class).getBody();

		// List<Post> post=new ArrayList<Post>(Arrays.asList(posts));

		return Arrays.asList(posts);
	}

	public String updatePostById(int id, Post post) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<Post> entity = new HttpEntity<>(post, httpHeaders);
		return restTemplate
				.exchange("https://jsonplaceholder.typicode.com/posts/" + id, HttpMethod.PUT, entity, String.class)
				.getBody();

	}

	// Display the total number of unique user id's;

	public Integer getCountOfUniqueUserIds() {

		List<Post> post = getPostList();
		List<Integer> userId = post.stream().map(p -> {
			return p.getUserId();
		}).distinct().collect(Collectors.toList());
		return userId.size();
	}

}
