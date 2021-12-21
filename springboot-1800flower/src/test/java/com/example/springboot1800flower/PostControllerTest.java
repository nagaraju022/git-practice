package com.example.springboot1800flower;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot1800flower.model.Post;
import com.example.springboot1800flower.repository.PostRepository;

@SpringBootTest
public class PostControllerTest {

	@Autowired
	PostRepository postRepository;
	
	
	@Test
	public void strTest() {
		String str="hello";
		String str2="hello";
		assertEquals(str, str2);
	}

	@Test
	public void getPostListTest() {
		List<Post> posts = postRepository.getPostList();
		int totalPosts = (int) posts.stream().map(Post::getId).count();
		assertEquals(100, totalPosts);
	}

	@Test
	public void updatePostOfTest() {
		
		int id=4;
		Post post=new Post();
		post.setUserId(5);
		post.setTitle("1800 flowers");
		post.setBody("1800 flowers");
		
		String postStr=postRepository.updatePostById(id, post);
	    assertNotEquals(15, postStr.length());
		
	}
	
	@Test
	public void getCountOfUniqueUserIdTest() {
		Integer count=postRepository.getCountOfUniqueUserIds();
		assertEquals(10, count);
		
	}
}
