package com.BlogApplication.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.BlogApplication.exceptions.ResourceNotFoundException;
import com.BlogApplication.model.Category;
import com.BlogApplication.payload.CategoryDto;
import com.BlogApplication.repository.CategoryRepo;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = categoryRepo.save(this.modelMapper.map(categoryDto, Category.class));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int id) {
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", id));
		category.setTitle(categoryDto.getTitle());
		category.setDescription(categoryDto.getDescription());
		// TODO Auto-generated method stub
		Category updatedCategory = categoryRepo.save(category);
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(CategoryDto categoryDto, int id) {
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", id));
		try {
			categoryRepo.delete(category);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryDto getCategoryById(int id) {
		Category category = categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category", "CategoryId", id));
		// TODO Auto-generated method stub
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories = categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map(categorydto-> modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
		// TODO Auto-generated method stub
		return categoryDtos;
	}

}
