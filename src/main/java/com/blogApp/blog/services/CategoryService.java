package com.blogApp.blog.services;

import com.blogApp.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //POST
    public CategoryDto createCategory(CategoryDto categoryDto);

    //UPDATE
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //DELETE
    public void deleteCategory(Integer categoryId);

    //GET
    public CategoryDto getCategoryById(Integer categoryId);

    //GETALL
    public List<CategoryDto> getAllCategory();
}
