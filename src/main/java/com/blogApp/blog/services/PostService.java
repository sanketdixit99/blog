package com.blogApp.blog.services;

import com.blogApp.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    //POST method
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //PUT method
    PostDto updatePost(PostDto postDto, Integer postId);

    //DELETE method
    void deletePost(Integer postId);

    //GET All method
    List<PostDto> getAllPost();

    //GET one method
    PostDto getPost(Integer postId);

    //GET All by User
    List<PostDto> getAllByUser(Integer userId);

    //GET All by category
    List<PostDto> getAllByCategory(Integer categoryId);

}
