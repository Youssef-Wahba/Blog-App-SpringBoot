package com.example.blogappspring;

import com.example.blogappspring.repository.PostRepo;
import com.example.blogappspring.service.IPostService;
import com.example.blogappspring.service.implementation.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BlogAppSpringApplication {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    };
    public static void main(String[] args) {
        SpringApplication.run(BlogAppSpringApplication.class, args);
    }

}
