package org.cefalo.storyDrops.repository;

import org.cefalo.storyDrops.model.Post;
import org.cefalo.storyDrops.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
