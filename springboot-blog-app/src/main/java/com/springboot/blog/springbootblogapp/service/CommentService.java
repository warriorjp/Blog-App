package com.springboot.blog.springbootblogapp.service;


import java.util.List;

import com.springboot.blog.springbootblogapp.model.CommentModel;


public interface CommentService {
  CommentModel createModel(long postId,CommentModel commentModel);
  
   List<CommentModel> getCommentById(long id);
   
   CommentModel getCommentByPostId(long id);
}
