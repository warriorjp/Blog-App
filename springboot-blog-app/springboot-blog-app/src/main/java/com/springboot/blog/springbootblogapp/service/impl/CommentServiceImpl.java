package com.springboot.blog.springbootblogapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.springbootblogapp.entity.Comment;
import com.springboot.blog.springbootblogapp.entity.Post;
import com.springboot.blog.springbootblogapp.exception.ResourceNotFoundException;
import com.springboot.blog.springbootblogapp.model.CommentModel;
import com.springboot.blog.springbootblogapp.repository.CommentRepository;
import com.springboot.blog.springbootblogapp.repository.PostRepository;
import com.springboot.blog.springbootblogapp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	
	private ModelMapper modelMapper;

	@Override
	public CommentModel createModel(long postId, CommentModel commentModel) {
		Comment comment = mapToEntity(commentModel);

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

		comment.setPost(post);

		Comment newComment = commentRepository.save(comment);
		return mapToDto(newComment);
	}

	@Override
	public List<CommentModel> getCommentById(long id) {
	   List<Comment> comments=commentRepository.findByPostId(id);
	   if(comments.isEmpty()) {
		   throw new ResourceNotFoundException("Post", "id", id);
	   }
		return comments.stream().map(comment-> mapToDto(comment)).collect(Collectors.toList());
	}
	
	
	@Override
	public CommentModel getCommentByPostId(long id) {
		Comment comment=commentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Posts", "id", id));
		return mapToDto(comment);
	}

	
	
	private CommentModel mapToDto(Comment comment) {
		CommentModel commentModel=modelMapper.map(comment, CommentModel.class);
		return commentModel;
	}

	private Comment mapToEntity(CommentModel commentModel) {
		Comment comment=modelMapper.map(commentModel, Comment.class);
		return comment;

	}

	
	
	

}
