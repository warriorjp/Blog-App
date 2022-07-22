package com.springboot.blog.springbootblogapp.service;


import com.springboot.blog.springbootblogapp.model.CommentModel;


public interface CommentService {
  CommentModel createModel(long postId,CommentModel commentModel);
}
