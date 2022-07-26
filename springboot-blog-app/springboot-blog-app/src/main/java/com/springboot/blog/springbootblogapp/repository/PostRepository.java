package com.springboot.blog.springbootblogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.blog.springbootblogapp.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
