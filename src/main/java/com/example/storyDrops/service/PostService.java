package com.example.storyDrops.service;

import com.example.storyDrops.model.Post;
import com.example.storyDrops.repository.PostRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post getPostById(int id) throws EntityNotFoundException{
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.orElseThrow(()-> new EntityNotFoundException("Invalid Post Id"));
    }

    public String createNewPost(Post post, String author, String author_email){
        postRepository.save(new Post(post, author, author_email));
        return "Post Created";
    }

    public Post updatePostById(int id, Post post, String author_email) throws Exception {
        Post currentPost = postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Invalid post id"));
        if(!(currentPost.getAuthor_email().equals(author_email))) {
            throw new Exception("Access Denied!!");
        }
        currentPost.setTitle(post.getTitle());
        currentPost.setBody(post.getBody());
        postRepository.save(currentPost);
        return post;

    }

    public String deletePostById(int id, String author_email)  throws Exception{
        Post post = postRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Invalid post id"));
        if(!(post.getAuthor_email().equals(author_email))) throw new Exception("Access Denied!!");
        postRepository.deleteById(id);
        return "Post Deleted";
    }


}
