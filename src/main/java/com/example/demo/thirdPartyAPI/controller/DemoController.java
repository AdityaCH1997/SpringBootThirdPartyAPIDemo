package com.example.demo.thirdPartyAPI.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.thirdPartyAPI.service.impl.DemoService;

@RestController
@RequestMapping("/apis")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@GetMapping("/getPosts")
	List<Map<String, Object>> getAllPosts() {
		
		return demoService.getAllPosts();
		
	}
	
	@GetMapping("/getPosts/{id}")
	Map<String, Object> getPostById(@PathVariable int id) {
		
		return demoService.getPostById(id);
		
	}
	
	@PostMapping("/createPosts")
	String createPosts(@RequestBody Map<String, Object> payload) {
		
		boolean status = demoService.createPost(payload);
		
		if(status) {
			return "Post created successfully";
		}
		else {
			return "Failed to create new post";
		}
	}
	
	@PutMapping("/updatePost/{id}")
	String updatePost(@RequestBody Map<String, Object> payload, @PathVariable int id) {
		
		boolean status = demoService.updatePost(payload, id);
		
		if(status) {
			return "Post " + id +" updated successfully";
		}
		else {
			return "Failed to update post id: "+ id;
		}
	}
	
	@DeleteMapping("/deletePost/{id}")
	String deletePost(@PathVariable int id) {
		
		boolean status = demoService.deletePost(id);
		
		if(status) {
			return "Post " + id +" deleted successfully";
		}
		else {
			return "Failed to delete post id: "+ id;
		}
	}
	
}
