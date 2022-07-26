package com.blogApp.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private int categoryId;

    @NotEmpty(message = "Category title cannot be empty")
    private String categoryTitle;

    @Size(max = 50, message = "Category description cannot exceed 50 characters")
    private String categoryDescription;
}
