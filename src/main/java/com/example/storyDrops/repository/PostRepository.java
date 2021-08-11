package com.example.storyDrops.repository;

import com.example.storyDrops.model.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
