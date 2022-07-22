package com.springboot.blog.springbootblogapp.service.impl;

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

	@Override
	public CommentModel createModel(long postId, CommentModel commentModel) {
		Comment comment = mapToEntity(commentModel);

		Post post = postRepository.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

		comment.setPost(post);

		Comment newComment = commentRepository.save(comment);
		return mapToDto(newComment);
	}

	private CommentModel mapToDto(Comment comment) {
		CommentModel com = new CommentModel();
		com.setBody(comment.getBody());
		com.setEmail(comment.getEmail());
		com.setId(comment.getId());
		com.setName(comment.getName());
		return com;
	}

	private Comment mapToEntity(CommentModel commentModel) {
		Comment comment = new Comment();
		comment.setBody(commentModel.getBody());
		comment.setEmail(commentModel.getEmail());
		comment.setId(commentModel.getId());
		comment.setName(commentModel.getName());
		return comment;

	}

}
