package com.springboot.blog.springbootblogapp.service.impl;


import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springboot.blog.springbootblogapp.model.PostModel;
import com.springboot.blog.springbootblogapp.model.PostResponse;
import com.springboot.blog.springbootblogapp.entity.Post;
import com.springboot.blog.springbootblogapp.exception.ResourceNotFoundException;
import com.springboot.blog.springbootblogapp.repository.PostRepository;
import com.springboot.blog.springbootblogapp.service.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public PostModel createPost(PostModel postModel) {

		Post post = new Post();
		post.setTitle(postModel.getTitle());
		post.setContent(postModel.getContent());
		post.setDescription(postModel.getDescription());
		Post savepost = postRepository.save(post);

		return mapDTO(savepost);
	}

	@Override
	public PostResponse getAllPosts(int pageNo,int pageSize) {
		Pageable pageable=PageRequest.of(pageNo, pageSize);		
		Page<Post> posts = postRepository.findAll(pageable);
		
		//get content from page object
		List<Post> listOfPost=posts.getContent();
		List<PostModel> contentList= listOfPost.stream().map(post -> mapDTO(post)).collect(Collectors.toList());
        PostResponse postResponse=new PostResponse();
        postResponse.setContent(contentList);
        postResponse.setPageSize(posts.getSize());
        postResponse.setPageNo(posts.getNumber());
        postResponse.setTotalElement(posts.getTotalElements());
        postResponse.setTotalPage(posts.getTotalPages());
        postResponse.setLast(posts.isLast());
        
        return postResponse;
	}

	private PostModel mapDTO(Post savepost) {

		PostModel postModel2 = new PostModel();
		postModel2.setId(savepost.getId());
		postModel2.setContent(savepost.getContent());
		postModel2.setDescription(savepost.getDescription());
		postModel2.setTitle(savepost.getTitle());

		return postModel2;
	}

	@Override
	public PostModel getPostsByID(long id) {
		Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		return mapDTO(post);
	}

	@Override
	public PostModel updatePost(PostModel postModel, long id) {
		// TODO Auto-generated method stub
		Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		post.setTitle(postModel.getTitle());
		post.setContent(postModel.getContent());
		post.setDescription(postModel.getDescription());
		Post updatePost=postRepository.save(post);
		return mapDTO(updatePost);
	}

	@Override
	
	public void DeletPostById(long id) {
	
		Post post=postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post", "id", id));
		postRepository.delete(post);
	}

}
