package com.blogApp.blog.services.impl;

import com.blogApp.blog.entities.*;
import com.blogApp.blog.exceptions.ResourceNotFoundException;
import com.blogApp.blog.payloads.PostDto;
import com.blogApp.blog.repositories.*;
import com.blogApp.blog.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId).orElseThrow(
                ()->new ResourceNotFoundException("User", "userId", userId));

        Category category = this.categoryRepo.findById(categoryId).orElseThrow(
                ()->new ResourceNotFoundException("Category", "categoryId", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setCategory(category);
        post.setUser(user);

        Post createdPost = this.postRepo.save(post);
        return this.modelMapper.map(createdPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<PostDto> getAllPost() {
        return null;
    }

    @Override
    public PostDto getPost(Integer postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> getAllByCategory(Integer categoryId) {
        return null;
    }
}
