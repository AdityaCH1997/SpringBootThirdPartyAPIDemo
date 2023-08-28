package com.example.demo.thirdPartyAPI.service;

import java.util.List;
import java.util.Map;

public interface IDemoService {

	public List<Map<String, Object>> getAllPosts();
	
	public Map<String, Object> getPostById(int id);
	
	public boolean createPost(Map<String, Object> posts);
	
	public boolean updatePost(Map<String, Object> post, int id);
	
	public boolean deletePost(int id);
	
}
