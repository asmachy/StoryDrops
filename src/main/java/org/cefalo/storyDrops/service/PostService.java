package org.cefalo.storyDrops.service;

import org.cefalo.storyDrops.model.Post;
import org.cefalo.storyDrops.repository.PostRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public Post getPostById(int id){
        Optional<Post> postOptional = postRepository.findById(id);
        return postOptional.orElse(null);
    }

    public String createNewPost(Post post, String author, String author_email){
        postRepository.save(new Post(post, author, author_email));
        return "Post Created";
    }

    public Post updatePostById(int id, JSONObject post){
        Post currentPost = postRepository.findById(id).orElse(null);
        if(currentPost== null) return null;
        if(post.get("title")!=null) currentPost.setTitle(post.get("title").toString());
        if(post.get("body")!=null) currentPost.setBody(post.get("body").toString());
        postRepository.save(currentPost);
        return currentPost;

    }

    public String deletePostById(int id){
        Post post = postRepository.findById(id).orElse(null);
        if(post== null) return null;
        postRepository.deleteById(id);
        return "Post Deleted";
    }


}
