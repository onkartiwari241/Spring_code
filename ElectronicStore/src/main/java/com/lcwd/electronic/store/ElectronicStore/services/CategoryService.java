package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.lcwd.electronic.store.ElectronicStore.dtos.PagableResponse;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto,String categoryId);

    void delete(String categoryId);

    PagableResponse<CategoryDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir);

    CategoryDto getById(String categoryId);

    List<CategoryDto> searchCategory(String keyword);
}
