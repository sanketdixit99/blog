package com.blogApp.blog.services;

import com.blogApp.blog.payloads.PostDto;
import com.blogApp.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //POST method
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //PUT method
    PostDto updatePost(PostDto postDto, Integer postId);

    //DELETE method
    void deletePost(Integer postId);

    //GET All method
    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    //GET one method
    PostDto getPost(Integer postId);

    //GET All by User
    List<PostDto> getAllPostByUser(Integer userId);

    //GET All by category
    List<PostDto> getAllPostByCategory(Integer categoryId);

    //search Posts
    List<PostDto> searchPosts(String keyword);

    //search posts by content
    List<PostDto> searchPostsByContent(String content);

}
