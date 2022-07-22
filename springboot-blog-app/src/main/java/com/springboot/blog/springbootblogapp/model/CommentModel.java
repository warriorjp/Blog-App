package com.springboot.blog.springbootblogapp.model;

import lombok.Data;

@Data
public class CommentModel {

	private long id;
	private String name;
	private String email;
	private String body;

}
