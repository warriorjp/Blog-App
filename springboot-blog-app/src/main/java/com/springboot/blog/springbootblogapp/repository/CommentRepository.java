package com.springboot.blog.springbootblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.blog.springbootblogapp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
