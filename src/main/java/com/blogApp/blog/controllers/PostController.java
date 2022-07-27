package com.blogApp.blog.controllers;

import com.blogApp.blog.payloads.PostDto;
import com.blogApp.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
        PostDto createdPostDto = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

}
