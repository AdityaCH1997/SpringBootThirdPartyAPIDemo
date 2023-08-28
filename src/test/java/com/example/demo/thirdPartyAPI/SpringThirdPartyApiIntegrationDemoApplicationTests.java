package com.example.demo.thirdPartyAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.thirdPartyAPI.service.impl.DemoService;

@SpringBootTest
class SpringThirdPartyApiIntegrationDemoApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	
	@Autowired
	private DemoService demoservice;
	
	@Test
	public void getAllPostsNullCheck() {
		assertNotNull(demoservice.getAllPosts(), "Unsuccessful READ Operation. Response is null");
	}
	
	@Test
	public void getPostByIdNullCheck() {
		assertNotNull(demoservice.getPostById(100), "Unsuccessful READ Operation. Response is null");
	}
	
	@Test
	public void getPostByIdEqualsCheck() {
		
		Map<String, Object> testResponseStub = new LinkedHashMap<>();
		testResponseStub.put("userId", 10);
		testResponseStub.put("id", 100);
		testResponseStub.put("title", "at nam consequatur ea labore ea harum");
		testResponseStub.put("body", "cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut");
		
		Map<String, Object> fetchedResponse = demoservice.getPostById(100);
		
		assertEquals(testResponseStub, fetchedResponse, "Stubbed response do not match fetched response");	
	}
	
	@Test
	public void createPostSuccessCheck() {
		Map<String, Object> testResponseStub = new LinkedHashMap<>();
		testResponseStub.put("userId", 11);
		testResponseStub.put("id", 101);
		testResponseStub.put("title", "Title 101");
		testResponseStub.put("body", "Sample Body 101");
		
		assertNotNull(demoservice.createPost(testResponseStub), "Unsuccessful CREATE Operation");
	}
	
	@Test
	public void createPostResponseCheck() {
		Map<String, Object> testResponseStub = new LinkedHashMap<>();
		testResponseStub.put("userId", 11);
		testResponseStub.put("id", 101);
		testResponseStub.put("title", "Title 101");
		testResponseStub.put("body", "Sample Body 101");	
		
		assertTrue(demoservice.createPost(testResponseStub), "Response Body doesn't match Request Payload");
	}
	
	@Test
	public void updatePostNullCheck() {
		Map<String, Object> testRequestStub = new LinkedHashMap<>();
		testRequestStub.put("userId", 10);
		testRequestStub.put("id", 100);
		testRequestStub.put("title", "Updated Title 100");
		testRequestStub.put("body", "Sample Updated Body 100");
		
		assertNotNull(demoservice.updatePost(testRequestStub, 100), "Unsuccessful UPDATE Operation");
	}
	
	@Test
	public void updatePostResponseCheck() {
		Map<String, Object> testRequestStub = new LinkedHashMap<>();
		testRequestStub.put("userId", 10);
		testRequestStub.put("id", 100);
		testRequestStub.put("title", "Updated Title 100");
		testRequestStub.put("body", "Sample Updated Body 100");
		
		assertTrue(demoservice.updatePost(testRequestStub, 100), "Unsuccessful UPDATE Operation");
	}
	
	@Test
	public void deletePostNullCheck() {
		int id = 100;
		
		assertNotNull(demoservice.deletePost(id), "Unsuccessful DELETE Operation");
	}
	
	@Test
	public void deletePostResponseCheck() {
		int id = 100;
		
		assertTrue(demoservice.deletePost(id), "Unsuccessful DELETE Operation");
	}

}
