package com.springboot.blog.springbootblogapp.controller;

import javax.persistence.PostUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.springbootblogapp.model.CommentModel;
import com.springboot.blog.springbootblogapp.service.CommentService;

@RestController
@RequestMapping("/api")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/posts/{postId}/comment")
	public ResponseEntity<CommentModel> createComment(@PathVariable(value = "postId") long id
			,@RequestBody CommentModel commentModel) {
		
		
		return new ResponseEntity<>(commentService.createModel(id, commentModel),HttpStatus.CREATED);
				
		
	}

}
