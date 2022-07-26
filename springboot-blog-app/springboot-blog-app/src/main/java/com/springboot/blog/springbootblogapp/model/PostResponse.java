package com.springboot.blog.springbootblogapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

	private List<PostModel> content;
	
	private int pageNo;
	
	private int pageSize;
	
	private long totalElement;
	
	private int totalPage;
	
	private boolean last;
	
}
