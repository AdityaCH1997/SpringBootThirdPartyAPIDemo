package com.example.demo.thirdPartyAPI.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.thirdPartyAPI.service.IDemoService;

//import lombok.val;

@Service
public class DemoService implements IDemoService{
	
	private final String BASE_URI = "https://jsonplaceholder.typicode.com/";
	
	StringBuilder uri = null;
	
	//Endpoints
	final String GET = "posts";
	final String GETById = "posts/";
	final String POST = "posts";
	final String PUT = "posts/";
	final String DELETE = "posts/";
	

	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> getAllPosts() {
		// TODO Auto-generated method stub
		HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
		uri = new StringBuilder(BASE_URI);
		String getAllPostsUrl = uri.append(GET).toString();
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<List> response = restTemplate.exchange(getAllPostsUrl, HttpMethod.GET, httpEntity, List.class);
		
		if(response != null) {
			return response.getBody();
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> getPostById(int id) {
		// TODO Auto-generated method stub
		HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
		uri = new StringBuilder(BASE_URI);
		String getPostByIdUrl = uri.append(GETById).append(id).toString();
		
		ResponseEntity<Map> response = restTemplate.exchange(getPostByIdUrl, HttpMethod.GET, httpEntity, Map.class);
		
		if(response != null) {
			return response.getBody();
		}	
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean createPost(Map<String, Object> post) {
		// TODO Auto-generated method stub
		HttpEntity<Map> httpEntity = new HttpEntity<>(post, gethttpHeaders());
		uri = new StringBuilder(BASE_URI);
		String createPostsUrl = uri.append(POST).toString();
		
		ResponseEntity<Map> response = restTemplate.exchange(createPostsUrl, HttpMethod.POST, httpEntity, Map.class);
		
		if(response != null && response.getBody() != null) {
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean updatePost(Map<String, Object> post, int id) {
		// TODO Auto-generated method stub
		HttpEntity<Map> httpEntity = new HttpEntity<>(post, gethttpHeaders());
		uri = new StringBuilder(BASE_URI);
		String updatePostUrl = uri.append(PUT).append(id).toString();
		
		ResponseEntity<Map> response = restTemplate.exchange(updatePostUrl, HttpMethod.PUT, httpEntity, Map.class);

		if(response != null && response.getBody() != null) {
			return true;
		}
		
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean deletePost(int id) {
		// TODO Auto-generated method stub
		HttpEntity<Void> httpEntity = new HttpEntity<>(gethttpHeaders());
		uri = new StringBuilder(BASE_URI);
		String deleteUrl = uri.append(DELETE).append(id).toString();
		
		ResponseEntity<Map> response = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, httpEntity, Map.class);
		
		if(response != null && response.getBody() != null) {
			return true;
		}
		
		return false;
	}
	
		
	private HttpHeaders gethttpHeaders(){
       HttpHeaders headers = new HttpHeaders();
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       headers.setContentType(MediaType.APPLICATION_JSON);
       return headers;
    }
	

}
