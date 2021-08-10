package org.cefalo.storyDrops.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.cefalo.storyDrops.dto.UpdatePostResponse;
import org.cefalo.storyDrops.model.Post;
import org.cefalo.storyDrops.repository.PostRepository;
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
        try{
            Post post =postService.getPostById(id);
            return new ResponseEntity<>(post, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("Invalid Post Id", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    public ResponseEntity<String> createPost(@Valid @RequestBody Post post) {
            String responseFromService = postService.createNewPost(post, "author name", "author@email.com");
            return new ResponseEntity<>(responseFromService, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable(value = "id") Integer id, @Valid @RequestBody Post post){
        try{
            Post responseFromService = postService.updatePostById(id, post);
            UpdatePostResponse responseData = new UpdatePostResponse();
            responseData.setMessage("Post Updated");
            responseData.setPost(new UpdatePostResponse.DemoPost(responseFromService.getTitle(),
                    responseFromService.getBody()));
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid Post Id",HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") Integer id){
        try{
            String responseFromService = postService.deletePostById(id);
            return new ResponseEntity<>("Post Deleted", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Invalid Post Id", HttpStatus.NOT_FOUND);
        }
    }
}
