package com.springboot.blog.springbootblogapp.service;

import java.util.List;

import com.springboot.blog.springbootblogapp.model.PostModel;





public interface PostService {


	PostModel createPost(PostModel postModel);
	
	List<PostModel> getAllPosts();
	
	PostModel getPostsByID(long id);
	
	PostModel updatePost(PostModel postModel,long id);
	
	void DeletPostById(long id);
	
}
