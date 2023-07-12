package com.example.blogappspring.controller;

import com.example.blogappspring.DTOs.PostDto;
import com.example.blogappspring.entity.Post;
import com.example.blogappspring.repository.PostRepo;
import com.example.blogappspring.service.IPostService;
import com.example.blogappspring.service.implementation.PostService;
import jakarta.ws.rs.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private IPostService postService;
    public PostController(IPostService postService) {
        this.postService = postService;
    }

//    create post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
       return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(),HttpStatus.OK);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "postId") long id){
        return new ResponseEntity<>(postService.getPostById(id),HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable(name = "postId") long id){
        System.out.println(postDto);
        return new ResponseEntity<>(postService.updatePost(id,postDto),HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable(name = "postId") long id){
        postService.deletePostById(id);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
