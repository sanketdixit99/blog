package com.blogApp.blog.controllers;

import com.blogApp.blog.payloads.ApiResponse;
import com.blogApp.blog.payloads.CategoryDto;
import com.blogApp.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //POST
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity(createCategory, HttpStatus.CREATED);
    }

    //PUT
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, categoryId);
        return new ResponseEntity(updatedCategory, HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity(new ApiResponse("Category deleted successfully", true), HttpStatus.OK);
    }

    //GET
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
        CategoryDto getCategoryDto = this.categoryService.getCategoryById(categoryId);
        return new ResponseEntity(getCategoryDto, HttpStatus.OK);
    }

    //GETALL
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        List<CategoryDto> categoryDtos = this.categoryService.getAllCategory();
        return ResponseEntity.ok(categoryDtos);
    }

}
