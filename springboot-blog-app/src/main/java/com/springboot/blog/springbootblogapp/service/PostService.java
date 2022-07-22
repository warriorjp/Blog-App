package com.springboot.blog.springbootblogapp.service;

import java.util.List;

import com.springboot.blog.springbootblogapp.model.PostModel;
import com.springboot.blog.springbootblogapp.model.PostResponse;


public interface PostService {


	PostModel createPost(PostModel postModel);
	
	PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortOrd);
	
	PostModel getPostsByID(long id);
	
	PostModel updatePost(PostModel postModel,long id);
	
	void DeletPostById(long id);
	
}
