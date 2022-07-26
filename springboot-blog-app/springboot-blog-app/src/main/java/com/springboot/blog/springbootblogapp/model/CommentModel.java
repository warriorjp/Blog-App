package com.springboot.blog.springbootblogapp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class CommentModel {

	private long id;
	@NotEmpty(message = "Name shouldnt be empty.")  //message will be throws if field is empty
	private String name;
	@NotEmpty(message = "Email shouldnt be empty. ")
	@Email(message = "Email shouldnt be empty or in correct format")
	private String email;
	@NotEmpty
	@Size(min=10, message = "Body shouldnt be empty.")
	private String body;

}
