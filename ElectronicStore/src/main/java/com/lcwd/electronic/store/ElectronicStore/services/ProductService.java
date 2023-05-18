package com.lcwd.electronic.store.ElectronicStore.services;

import com.lcwd.electronic.store.ElectronicStore.dtos.PagableResponse;
import com.lcwd.electronic.store.ElectronicStore.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    // create
    ProductDto create(ProductDto productDto);

    // update
    ProductDto update(ProductDto productDto,String productId);

    // delete
    void delete(String productId);

    // get single product By Id
    ProductDto productById(String productId);

    // get all products
    PagableResponse<ProductDto> allProducts(int pageNumber,int pageSize,String sortBy,String sortDir);

    // get all live products
    PagableResponse<ProductDto> getAllLive(int pageNumber,int pageSize,String sortBy,String sortDir);

    // search avilable products by keyword of tittle only
    PagableResponse<ProductDto> searchByTittle(String subTittle,int pageNumber,int pageSize,String sortBy,String sortDir);

    // create product with category

    ProductDto createWithCategory(ProductDto productDto, String categoryId);

    ProductDto updateCategory(String productid,String categoryId);

    PagableResponse<ProductDto> getAllProductsOfRelatedCategory(String categoryId,int pageNumber,int pageSize,String sortBy,String sortDir);
}
