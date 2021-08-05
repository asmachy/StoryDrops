package com.example.authentication.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping("")
    public String getPosts(){
        return "1,2,3";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable(value = "id") Integer id)
    {
        return new ResponseEntity<>(id.toString(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> createPost(@Valid @RequestBody JSONObject obj) {
        return new ResponseEntity<>(obj, HttpStatus.OK);
//        String responseFromService ="Post Created\n title: "+ obj.get("title")+"\n body: "+ obj.get("body");
//        return new ResponseEntity<>(responseFromService, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@PathVariable(value = "id") Integer id, @Valid @RequestBody JSONObject post){
        String responseData = "Put Successful";
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable(value = "id") Integer id){
        return new ResponseEntity<>("Post Deleted", HttpStatus.OK);
    }
}
