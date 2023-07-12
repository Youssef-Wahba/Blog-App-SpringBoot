package com.example.blogappspring.service.implementation;

import com.example.blogappspring.DTOs.PostDto;
import com.example.blogappspring.entity.Post;
import com.example.blogappspring.exception.ResourceNotFoundException;
import com.example.blogappspring.repository.PostRepo;
import com.example.blogappspring.service.IPostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {
    private PostRepo repo;
    private ModelMapper mapper;

    public PostService(PostRepo repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post createdPost = repo.save(mapToEntity(postDto));
        return mapToDTO(createdPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = repo.findAll();
        return posts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        return mapToDTO(repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post" , "id", Long.toString(id))));
    }

    @Override
    public PostDto updatePost(long id, PostDto postDto) {
        Post post = repo.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",Long.toString(id)));
//        if conditions if certain attribute is not passed in the body
        if(postDto.getContent() != null) post.setContent(postDto.getContent());
        if(postDto.getDescription() != null) post.setDescription(postDto.getDescription());
        if(postDto.getTitle() != null) post.setTitle(postDto.getTitle());
        return mapToDTO(repo.save(post));
    }

    @Override
    public void deletePostById(long id) {
        repo.delete(repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",Long.toString(id))));
    }

    public PostDto mapToDTO(Post post){
//        return mapper.map(post,PostDto.class);
        return new PostDto(post.getId(), post.getTitle(),post.getDescription(),post.getContent());
    }
    public Post mapToEntity(PostDto postDto){
//        return mapper.map(postDto,Post.class);
    Post post = new Post();
    post.setTitle(postDto.getTitle());
    post.setId(postDto.getId());
    post.setContent(postDto.getContent());
    post.setDescription(postDto.getDescription());
    return post;
    }

}