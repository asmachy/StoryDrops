package org.cefalo.storyDrops.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.cefalo.storyDrops.model.Post;
import org.cefalo.storyDrops.model.User;
import org.cefalo.storyDrops.repository.PostRepository;
import org.cefalo.storyDrops.repository.UserRepository;
import org.cefalo.storyDrops.service.PostService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getPosts(){
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable(value = "id") Integer id)
    {
        Post post =postService.getPostById(id);
        if(post==null) return new ResponseEntity<>("Invalid Post Id", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> createPost(@Valid @RequestBody Post post) {
            String responseFromService = postService.createNewPost(post, "Asma Ul Husna", "asma@c.com");
            return new ResponseEntity<>(responseFromService, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable(value = "id") Integer id, @Valid @RequestBody JSONObject post){
        Post responseFromService = postService.updatePostById(id, post);
        if(responseFromService == null) return new ResponseEntity<>("Invalid Post Id",HttpStatus.NOT_FOUND);
        JSONObject responseData=new JSONObject();
        responseData.put("message","Post Created");
        responseData.put("post", responseFromService);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") Integer id){
        String responseFromService = postService.deletePostById(id);
        if(responseFromService == null) return new ResponseEntity<>("Invalid Post Id", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Post Deleted", HttpStatus.OK);
    }
}
