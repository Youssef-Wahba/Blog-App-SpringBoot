package com.example.blogappspring.service;

import com.example.blogappspring.DTOs.PostDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;
public interface IPostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);

    PostDto updatePost(long id,PostDto postDto);
    void deletePostById(long id);
}
