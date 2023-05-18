package com.lcwd.electronic.store.ElectronicStore.services.implementation;

import com.lcwd.electronic.store.ElectronicStore.dtos.CategoryDto;
import com.lcwd.electronic.store.ElectronicStore.dtos.PagableResponse;
import com.lcwd.electronic.store.ElectronicStore.entities.Category;
import com.lcwd.electronic.store.ElectronicStore.helper.Helper;
import com.lcwd.electronic.store.ElectronicStore.repositories.CategoryRepository;
import com.lcwd.electronic.store.ElectronicStore.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImple implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto create(CategoryDto categoryDto) {

        // create categoryId randomly

        String generatedCategoryId = UUID.randomUUID().toString();
        categoryDto.setCategoriId(generatedCategoryId);

        Category category = modelMapper.map(categoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory,CategoryDto.class);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto, String categoryId) {

        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("id not found"));

        category.setTittle(categoryDto.getTittle());
        category.setDescription(categoryDto.getDescription());
        category.setCoverImage(categoryDto.getCoverImage());

        Category updatedData = categoryRepository.save(category);
        return modelMapper.map(updatedData,CategoryDto.class);
    }

    @Override
    public void delete(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("id not found"));

        categoryRepository.delete(category);
    }


    @Override
    public PagableResponse<CategoryDto> getAll(int pageNumber,int pageSize,String sortBy,String sortDir) {

        Sort sort=(sortDir.equalsIgnoreCase("desc"))?(Sort.by(sortBy).descending()):(Sort.by(sortBy).ascending());
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sort);
        Page<Category> page = categoryRepository.findAll(pageable);
        PagableResponse<CategoryDto> pagableResponse = Helper.getPagableResponse(page, CategoryDto.class);
        return pagableResponse;
    }

    @Override
    public CategoryDto getById(String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("id not found"));

        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> searchCategory(String keyword) {

//      findByNameKeyword() method is written in CategogyRepository
        List<Category> byNameKeyword = categoryRepository.findByTittleContaining(keyword);

        List<CategoryDto> dtoList = byNameKeyword
                .stream().map(category -> entityToDto(category)).collect(Collectors.toList());
        return dtoList;
    }

    private CategoryDto entityToDto(Category category){
        return modelMapper.map(category,CategoryDto.class);
    }
    private Category dtoTOEntity(CategoryDto categoryDto)
    {
        return modelMapper.map(categoryDto,Category.class);
    }
}
