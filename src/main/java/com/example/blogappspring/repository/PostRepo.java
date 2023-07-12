package com.example.blogappspring.repository;

import com.example.blogappspring.DTOs.PostDto;
import com.example.blogappspring.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {



}
