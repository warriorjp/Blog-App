package com.springboot.blog.springbootblogapp.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PostModel {
	private long id;
	
	@NotEmpty
	@Size(min=2,message = "Post title should have at least 2 characters")
	private String title;
	@NotEmpty
	private String description;
	@NotEmpty
	private String content;

}
