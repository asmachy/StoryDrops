package com.example.storyDrops.controller;

import com.example.storyDrops.model.LoginUserDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.example.storyDrops.dto.UpdatePostResponse;
import com.example.storyDrops.model.Post;
import com.example.storyDrops.repository.PostRepository;
import com.example.storyDrops.service.PostService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public List<Post> getPosts(){
        List <Post> responseData = postService.getAllPost();

        responseData.sort(
                (Post p1, Post p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));
        return responseData;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable(value = "id") Integer id)
    {
        try{
            List <Post> responseData = new ArrayList<Post>();
            Post post =postService.getPostById(id);
            responseData.add(post);
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Invalid Post Id", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> createPost(@Valid @RequestBody Post post, Authentication authentication) {
            String responseFromService = postService.createNewPost(post, ((LoginUserDetails)authentication.getPrincipal()).getFullname()
                    ,  ((LoginUserDetails)authentication.getPrincipal()).getEmail());
            return new ResponseEntity<>(responseFromService, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable(value = "id") Integer id, @Valid @RequestBody Post post, Authentication authentication){
        try{
            Post responseFromService = postService.updatePostById(id, post
                    ,((LoginUserDetails)authentication.getPrincipal()).getEmail());
            UpdatePostResponse responseData = new UpdatePostResponse();
            responseData.setMessage("Post Updated");
            responseData.setPost(new UpdatePostResponse.DemoPost(responseFromService.getTitle(),
                    responseFromService.getBody()));
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>("Invalid Post Id",HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") Integer id, Authentication authentication){
        try{
            String responseFromService = postService.deletePostById(id
                    ,  ((LoginUserDetails)authentication.getPrincipal()).getEmail());
            return new ResponseEntity<>(responseFromService, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
        }

    }
}
