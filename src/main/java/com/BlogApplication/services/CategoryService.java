package com.BlogApplication.services;

import java.util.List;

import com.BlogApplication.payload.CategoryDto;

public interface CategoryService {
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto, int id);
	void deleteCategory(CategoryDto categoryDto, int id);
	CategoryDto getCategoryById(int id);
	List<CategoryDto> getCategories();
	

}
