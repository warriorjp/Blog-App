package com.springboot.blog.springbootblogapp.controller;

import java.util.List;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.springbootblogapp.model.PostModel;
import com.springboot.blog.springbootblogapp.model.PostResponse;
import com.springboot.blog.springbootblogapp.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@PostMapping
	public ResponseEntity<PostModel> createPost(@RequestBody PostModel postModel) {

		return new ResponseEntity<>(postService.createPost(postModel), HttpStatus.CREATED);
	}

	@GetMapping
	public PostResponse getAllPost(@RequestParam(value = "pageNo", defaultValue = "0",required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "10",required = false) int pageSize) {
		return postService.getAllPosts(pageNo,pageSize);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostModel> getPostById(@PathVariable long id) {
		return ResponseEntity.ok(postService.getPostsByID(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<PostModel> updtePost(@RequestBody PostModel postModel,@PathVariable long id) {
		return ResponseEntity.ok(postService.updatePost(postModel,id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePost(@PathVariable long id) {
		postService.DeletPostById(id);
		return ResponseEntity.ok("Post Deleted");
	}

}
