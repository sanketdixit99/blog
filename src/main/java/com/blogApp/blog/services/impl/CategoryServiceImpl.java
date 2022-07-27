package com.blogApp.blog.services.impl;

import com.blogApp.blog.entities.Category;
import com.blogApp.blog.exceptions.ResourceNotFoundException;
import com.blogApp.blog.payloads.CategoryDto;
import com.blogApp.blog.repositories.CategoryRepo;
import com.blogApp.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        cat.setCategoryTitle(categoryDto.getCategoryTitle());
        cat.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(updatedCat, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        this.categoryRepo.delete(cat);

    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category cat = this.categoryRepo.findById(categoryId).orElseThrow(
                ()-> new ResourceNotFoundException("Category", "CategoryId", categoryId));

        return this.modelMapper.map(cat, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categories= this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();

        for(Category cat: categories){
            categoryDtos.add(this.modelMapper.map(cat, CategoryDto.class));
        }
        return categoryDtos;
    }
}
