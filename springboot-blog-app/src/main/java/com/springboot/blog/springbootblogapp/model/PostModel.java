package com.springboot.blog.springbootblogapp.model;

import lombok.Data;

@Data
public class PostModel {
	private long id;
	private String title;
	private String description;
	private String content;

}
