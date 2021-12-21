package com.example.springboot1800flower;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.springboot1800flower.controller.PostController;
import com.example.springboot1800flower.model.Post;
import com.example.springboot1800flower.repository.PostRepository;

@SpringBootTest
class Springboot1800flowerApplicationTests {
	
@MockBean
private PostRepository postRepository;

	@Test
	void firstTest() {
		assertEquals(10, 10);
	}

	
	@Test
	public void getPostListTest() {
		Mockito.when(postRepository.getPostList()).thenReturn(Arrays.asList(new Post(1, 1, "flowers", "description of flower"),
				new Post(1, 2, "fruit", "description of fruit"),new Post(2, 3, "vegetable", "description of vegetable")));
		assertEquals(3, postRepository.getPostList().size());
	}

	@Test
	public void updatePostTest() {
		
		int id=4;
		
		Post p=new Post();
		p.setUserId(1);
		p.setTitle("Apple");
		p.setBody("Description of apple");
		Mockito.when(postRepository.updatePostById(id, p)).thenReturn("{\n" + 
			"    \"userId\": 1,\n" + 
			"    \"id\": 4,\n" + 
			"    \"title\": \"Apple\",\n" + 
			"    \"body\": \"Description of apple\"\n" + 
			"}");
		
		
		
	assertEquals("{\n" + 
			"    \"userId\": 1,\n" + 
			"    \"id\": 4,\n" + 
			"    \"title\": \"Apple\",\n" + 
			"    \"body\": \"Description of apple\"\n" + 
			"}", postRepository.updatePostById(id, p));
		
		
	}

	
	@Test
	public void getCountOfUniqueUserIdTest() {
		Mockito.when(postRepository.getCountOfUniqueUserIds()).thenReturn(20);
		assertEquals(20, postRepository.getCountOfUniqueUserIds());
		
	}

	
	
}
